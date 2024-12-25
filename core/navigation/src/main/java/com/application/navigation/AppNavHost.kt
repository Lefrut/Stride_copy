package com.application.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.application.home.navigation.homeScreen
import com.application.home.navigation.navigateToHome
import com.application.login.navigation.LoginRoute
import com.application.login.navigation.loginScreen
import com.application.login.navigation.navigateToLogin
import com.application.register.navigation.RegisterRoute
import com.application.register.navigation.navigateToRegister
import com.application.register.navigation.registerScreen
import com.application.start.navigation.StartRoute
import com.application.start.navigation.startScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    showSnackbar: (String, Boolean) -> Unit
) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = StartRoute
    ) {
        startScreen(
            onNavigateToRegister = {
                navController.navigateToRegister {
                    launchSingleTop = true
                }
            },
            onNavigateToLogin = {
                navController.navigateToLogin {
                    launchSingleTop = true
                }
            }
        )

        loginScreen(
            onNavigateToRegister = {
                navController.navigateToRegister {
                    launchSingleTop = true
                    popUpTo(LoginRoute){ inclusive = true }
                }
            },
            onNavigateToHome = {
                navController.navigateToHome {
                    launchSingleTop = true
                    popUpTo(StartRoute) { inclusive = true }
                }
            },
            onShowSnackBar = { message, isSuccess ->
                showSnackbar(message, isSuccess)
            }
        )

        registerScreen(
            onNavigateToLogin = {
                navController.navigateToLogin {
                    launchSingleTop = true
                    popUpTo(RegisterRoute){ inclusive = true }
                }
            },
            onNavigateToHome = {
                navController.navigateToHome {
                    launchSingleTop = true
                    popUpTo(StartRoute) { inclusive = true }
                }
            },
            onShowSnackBar = showSnackbar
        )

        homeScreen()
    }

}