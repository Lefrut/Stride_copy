package com.application.register;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.register.components.RegisterBody
import com.application.register.components.RegisterTitle
import com.application.register.model.mvi.RegisterState

@Composable
fun RegisterScreen(
    viewState: RegisterState,
    onPhoneChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onPasswordVisibilitySwitch: (Boolean) -> Unit,
    onLoginSwitch: () -> Unit,
    onNameChange: (String) -> Unit,
    onSurnameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit
) {
    if (viewState is RegisterState.Success) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.navigationBars)
        ) {
            RegisterTitle(Modifier.padding(top = 78.dp))
            RegisterBody(
                name = viewState.name,
                onNameChange = onNameChange,
                surname = viewState.surname,
                onSurnameChange = onSurnameChange,
                email = viewState.email,
                onEmailChange = onEmailChange,
                password = viewState.password,
                onPasswordChange = onPasswordChange,
                showPassword = viewState.showPassword,
                onPasswordVisibilitySwitch = onPasswordVisibilitySwitch,
                confirmPassword = viewState.confirmPassword,
                onConfirmPasswordChange = onConfirmPasswordChange,
                phone = viewState.phone,
                onPhoneChange = onPhoneChange,
                onRegisterClick = onRegisterClick,
                onLoginSwitch = onLoginSwitch
            )
        }
    }
}
