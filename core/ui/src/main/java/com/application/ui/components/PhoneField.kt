package com.application.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.application.common_ui.text.PhoneVisualTransformation
import com.application.resources.R
import com.application.ui.theme.labelLargeLow

@Composable
fun PhoneField(
    modifier: Modifier = Modifier,
    phone: String,
    onPhoneChange: (String) -> Unit,
    countryCallingCode: String = stringResource(R.string.russian_call_code),
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    StrideOutlineTextField(
        modifier = modifier,
        value = phone,
        onValueChange = onPhoneChange,
        prefix = {
            Text(
                text = countryCallingCode,
                style = MaterialTheme.typography.labelLargeLow
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        visualTransformation = PhoneVisualTransformation()
    )

}