package com.application.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.application.resources.R
import com.application.ui.theme.titleMediumVariant

@Composable
fun LoginTitle(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 35.dp)) {
        Text(
            text = stringResource(R.string.login_screen_title),
            color = MaterialTheme.colorScheme.onBackground.copy(0.9f),
            style = MaterialTheme.typography.titleMediumVariant
        )
        Text(
            text = stringResource(R.string.login_screen_subtitle),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
            style = MaterialTheme.typography.bodySmall
        )
    }
}