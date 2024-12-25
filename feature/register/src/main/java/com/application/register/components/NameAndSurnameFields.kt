package com.application.register.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.application.resources.R
import com.application.ui.components.StrideOutlineTextField


@Composable
fun NameAndSurnameFields(
    name: String,
    onNameChange: (String) -> Unit,
    surname: String,
    onSurnameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        val textFieldModifier = Modifier.weight(1f)

        StrideOutlineTextField(
            value = name,
            onValueChange = onNameChange,
            label = stringResource(R.string.name),
            modifier = textFieldModifier
        )

        Spacer(Modifier.width(10.dp))

        StrideOutlineTextField(
            value = surname,
            onValueChange = onSurnameChange,
            label = stringResource(R.string.surname),
            modifier = textFieldModifier
        )
    }
}