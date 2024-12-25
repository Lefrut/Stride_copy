package com.application.login;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.application.login.model.mvi.LoginEffect
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun LoginRoute(onNavigateToRegister: () -> Unit, onNavigateToHome: () -> Unit, onShowSnackBar: (String, Boolean) -> Unit) {
    val viewModel = koinViewModel<LoginViewModel>()
    val viewState by viewModel.collectAsState()


    LoginScreen(
        viewState = viewState,
        onPhoneChange = { newPhone ->
            viewModel.changePhone(newPhone)
        },
        onPasswordChange = { newPassword ->
            viewModel.changePassword(newPassword)
        },
        onLoginClick = {
            viewModel.login()
        },
        onPasswordVisibilitySwitch = { newValue ->
            viewModel.showPassword(newValue)
        },
        onRegisterClick = {
            viewModel.clickRegister()
        }
    )


    viewModel.collectSideEffect { effect ->
        when(effect){
            LoginEffect.NavigateToRegister -> onNavigateToRegister()
            LoginEffect.NavigateToHome -> onNavigateToHome()
            is LoginEffect.ShowError -> onShowSnackBar(effect.message, false)
        }
    }
}