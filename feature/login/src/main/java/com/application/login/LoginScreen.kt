package com.application.login;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.application.login.components.LoginBody
import com.application.login.components.LoginTitle
import com.application.login.model.mvi.LoginState
import com.application.resources.R
import com.application.ui.components.StrideButton

@Composable
fun LoginScreen(
    viewState: LoginState,
    onPhoneChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onPasswordVisibilitySwitch: (Boolean) -> Unit,
    onRegisterClick: () -> Unit
) {
    if (viewState is LoginState.Success) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.navigationBars)
        ) {
            LoginTitle(Modifier.padding(top = 78.dp))
            LoginBody(
                phone = viewState.phone,
                onPhoneChange = onPhoneChange,
                password = viewState.password,
                onPasswordChange = onPasswordChange,
                showPassword = viewState.showPassword,
                onPasswordVisibilitySwitch = onPasswordVisibilitySwitch,
                onLoginClick = onLoginClick,
                onRegisterClick = onRegisterClick
            )

        }
    }
}
