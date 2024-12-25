package com.application.register.components

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
import com.application.ui.components.StrideOutlineTextField
import com.application.ui.components.TwoPartText


private val textFieldModifier = Modifier
    .padding(top = 10.dp)
    .fillMaxWidth()

@Composable
fun RegisterBody(
    modifier: Modifier = Modifier,
    name: String,
    onNameChange: (String) -> Unit,
    surname: String,
    onSurnameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    showPassword: Boolean,
    onPasswordVisibilitySwitch: (Boolean) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChange: (String) -> Unit,
    phone: String,
    onPhoneChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onLoginSwitch: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NameAndSurnameFields(
            modifier = textFieldModifier,
            name = name,
            onNameChange = onNameChange,
            surname = surname,
            onSurnameChange = onSurnameChange
        )

        StrideOutlineTextField(
            value = email,
            onValueChange = onEmailChange,
            label = stringResource(R.string.email),
            modifier = textFieldModifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        PasswordField(
            modifier = textFieldModifier,
            password = password,
            onPasswordChange = onPasswordChange,
            showPassword = showPassword,
            onPasswordVisibilitySwitch = onPasswordVisibilitySwitch,
        )

        PasswordField(
            modifier = textFieldModifier,
            password = confirmPassword,
            onPasswordChange = onConfirmPasswordChange,
            showPassword = showPassword,
            onPasswordVisibilitySwitch = onPasswordVisibilitySwitch,
            label = stringResource(R.string.confirm_password)
        )

        PhoneField(
            modifier = textFieldModifier,
            phone = phone,
            onPhoneChange = onPhoneChange,
            keyboardActions = KeyboardActions {
                onRegisterClick()
            },
            imeAction = ImeAction.Done
        )


        StrideButton(
            modifier = Modifier.padding(top = 53.dp).fillMaxWidth(),
            text = stringResource(R.string.register),
            onClick = onRegisterClick
        )

        TwoPartText(
            modifier = Modifier.padding(top = 13.dp),
            text = stringResource(R.string.have_account),
            clickableText = stringResource(R.string.login),
            onClick = onLoginSwitch
        )
    }
}