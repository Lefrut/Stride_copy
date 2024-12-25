package com.application.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.application.home.HomeRoute
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute


fun NavController.navigateToHome(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(HomeRoute, builder)
}

fun NavGraphBuilder.homeScreen() {
    composable<HomeRoute> {
        HomeRoute()
    }
}