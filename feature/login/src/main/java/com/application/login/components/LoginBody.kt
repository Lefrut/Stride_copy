package com.application.login.components;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.application.resources.R
import com.application.ui.components.PasswordField
import com.application.ui.components.PhoneField
import com.application.ui.components.StrideButton
import com.application.ui.components.TwoPartText

private val textFieldModifier = Modifier.padding(top = 10.dp).fillMaxWidth()

@Composable
fun LoginBody(
    modifier: Modifier = Modifier,
    phone: String,
    onPhoneChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    showPassword: Boolean,
    onPasswordVisibilitySwitch: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        PhoneField(
            modifier = textFieldModifier,
            phone = phone,
            onPhoneChange = onPhoneChange,
        )

        PasswordField(
            modifier = textFieldModifier,
            password = password,
            onPasswordChange = onPasswordChange,
            showPassword = showPassword,
            onPasswordVisibilitySwitch = { newShowPassword ->
                onPasswordVisibilitySwitch(newShowPassword)
            },
            keyboardActions = KeyboardActions{ onLoginClick() },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        StrideButton(
            modifier = Modifier
                .padding(top = 45.dp)
                .fillMaxWidth(),
            onClick = onLoginClick,
            text = stringResource(R.string.login)
        )

        LoginDivider(Modifier.padding(top = 32.dp))

        GoogleSignInButton(
            modifier = Modifier.padding(top = 45.dp),
            onClick = {

            }
        )

        TwoPartText(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(R.string.no_account),
            clickableText = stringResource(R.string.sign_up),
            onClick = onRegisterClick
        )
    }
}