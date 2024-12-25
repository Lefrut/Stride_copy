package com.application.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.application.register.RegisterRoute
import kotlinx.serialization.Serializable

@Serializable
data object RegisterRoute

fun NavController.navigateToRegister(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(RegisterRoute, builder)
}

fun NavGraphBuilder.registerScreen(onNavigateToLogin: () -> Unit, onNavigateToHome: () -> Unit, onShowSnackBar: (String, Boolean) -> Unit) {
    composable<RegisterRoute> {
        RegisterRoute(
            onNavigateToLogin = onNavigateToLogin,
            onNavigateToHome = onNavigateToHome,
            onShowSnackBar = onShowSnackBar
        )
    }
}