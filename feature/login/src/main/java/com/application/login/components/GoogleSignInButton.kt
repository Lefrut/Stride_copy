package com.application.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.application.resources.R
import com.application.ui.theme.labelMediumLow

@Composable
fun GoogleSignInButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    OutlinedButton(
        modifier = modifier.sizeIn(minHeight = 45.dp).fillMaxWidth(),
        onClick = onClick,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            modifier = Modifier.padding(end = 9.dp),
            painter = painterResource(R.drawable.google),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.sign_in_with_google),
            color = MaterialTheme.colorScheme.outline,
            style = MaterialTheme.typography.labelMediumLow
        )
    }
}