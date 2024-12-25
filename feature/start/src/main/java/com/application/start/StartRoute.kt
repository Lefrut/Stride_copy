package com.application.start

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.application.start.model.mvi.StartEffect
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun StartRoute(
    onNavigateToLogin: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    val viewModel = koinViewModel<StartViewModel>()
    val viewState by viewModel.collectAsState()


    StartScreen(
        viewState = viewState,
        onLoginClick = { viewModel.clickLogin() },
        onRegisterClick = { viewModel.clickRegister() }
    )

    viewModel.collectSideEffect { effect ->
        when (effect) {
            StartEffect.NavigateToLogin -> onNavigateToLogin()
            StartEffect.NavigateToRegister -> onNavigateToRegister()
        }
    }
}