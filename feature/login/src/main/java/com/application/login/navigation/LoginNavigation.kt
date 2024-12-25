package com.application.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.application.login.LoginRoute
import kotlinx.serialization.Serializable

@Serializable
data object LoginRoute

fun NavController.navigateToLogin(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(LoginRoute, builder)
}

fun NavGraphBuilder.loginScreen(
    onNavigateToRegister: () -> Unit,
    onNavigateToHome: () -> Unit,
    onShowSnackBar: (String, Boolean) -> Unit
) {
    composable<LoginRoute> {

        LoginRoute(
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToHome = onNavigateToHome,
            onShowSnackBar = onShowSnackBar
        )
    }
}