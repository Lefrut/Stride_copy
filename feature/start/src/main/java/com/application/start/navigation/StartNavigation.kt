package com.application.start.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.start.StartRoute
import kotlinx.serialization.Serializable


@Serializable
data object StartRoute

fun NavGraphBuilder.startScreen(onNavigateToLogin: () -> Unit, onNavigateToRegister: () -> Unit) {
    composable<StartRoute> {
        StartRoute(
            onNavigateToLogin = onNavigateToLogin,
            onNavigateToRegister = onNavigateToRegister
        )
    }
}