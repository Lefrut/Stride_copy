package com.application.stride.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.application.navigation.AppNavHost
import com.application.navigation.model.BottomBarRoutes
import com.application.navigation.model.BottomNavigationItem
import com.application.ui.components.AppBottomBarItem
import com.application.ui.components.StrideBottomBar
import com.application.ui.components.StrideSnackBar
import com.application.ui.components.StrideSnackBarVisuals
import kotlinx.coroutines.launch

@Composable
fun StrideApp(
    navHostController: NavHostController = rememberNavController(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val hierarchy = currentDestination?.hierarchy?.toList()

    val isBottomBarRoute =
        BottomBarRoutes.any { kClass -> currentDestination?.hasRoute(kClass) == true }

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = isBottomBarRoute,
                enter = scaleIn(tween(300)),
                exit = scaleOut(tween(200))
            ) {
                StrideBottomBar {
                    BottomNavigationItem.entries.forEach { item ->
                        val itemSelected = hierarchy?.any { destination ->
                            destination.hasRoute(item.routeClass)
                        } == true
                        AppBottomBarItem(
                            iconId = item.iconId,
                            selected = itemSelected,
                            onClick = {
                                navHostController.navigate(item.routeClass) {
                                    popUpTo(navHostController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                        )
                        if (BottomNavigationItem.entries.last() != item) {
                            Spacer(Modifier.weight(1f))
                        }
                    }
                }
            }
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState) { snackbarData ->
                StrideSnackBar(snackbarData = snackbarData)
            }
        },
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { scaffoldPadding ->

        val appPadding = if (isBottomBarRoute) PaddingValues(0.dp) else scaffoldPadding

        Column(
            modifier = Modifier
                .padding(appPadding)
                .consumeWindowInsets(appPadding)
        ) {
            AppNavHost(
                navController = navHostController,
                showSnackbar = { message, isSuccess ->
                    coroutineScope.launch {
                        snackbarHostState.currentSnackbarData?.dismiss()
                        snackbarHostState.showSnackbar(StrideSnackBarVisuals(message, isSuccess))
                    }
                }
            )
        }
    }
}
