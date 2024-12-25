package com.application.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.application.common_ui.preview.DarkPreview
import com.application.resources.R
import com.application.ui.theme.StrideTheme
import com.application.ui.theme.bodyVerySmall
import com.application.ui.theme.success


@Composable
fun StrideSnackBar(
    modifier: Modifier = Modifier,
    snackbarData: SnackbarData
) {

    val isSuccess = (snackbarData.visuals as StrideSnackBarVisuals).isSuccess

    Snackbar(
        modifier = modifier.padding(horizontal = 15.dp, vertical = 10.dp),
        shape = MaterialTheme.shapes.medium,
        containerColor = if (isSuccess) MaterialTheme.colorScheme.success else MaterialTheme.colorScheme.error,
        contentColor = MaterialTheme.colorScheme.onBackground,
    ) {
        Row(
            Modifier.padding(vertical = 10.dp, horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(if (isSuccess) R.drawable.success else R.drawable.error),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )

            Column(modifier = Modifier.padding(start = 14.dp, end = 4.dp)) {

                val labelMedium = MaterialTheme.typography.labelMedium

                Text(
                    text = if (isSuccess) stringResource(R.string.successfully) else stringResource(
                        R.string.mistake
                    ),
                    style = labelMedium.copy(lineHeight = labelMedium.fontSize),
                    color = MaterialTheme.colorScheme.onBackground
                )

                val bodyVerySmall = MaterialTheme.typography.bodyVerySmall

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = snackbarData.visuals.message,
                    style = bodyVerySmall.copy(lineHeight = bodyVerySmall.fontSize),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Immutable
class StrideSnackBarVisuals(
    override val message: String,
    val isSuccess: Boolean,
    override val actionLabel: String? = null,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    override val withDismissAction: Boolean = false,
): SnackbarVisuals


@DarkPreview
@Composable
private fun  SnackbarPreview() {
    StrideTheme {
        StrideSnackBar(
            snackbarData = object : SnackbarData {
                override val visuals: SnackbarVisuals
                    get() = StrideSnackBarVisuals("Hello", false)

                override fun dismiss() {}

                override fun performAction() {}

            }
        )
    }
}

@DarkPreview
@Composable
private fun  FailSnackbarPreview() {
    StrideTheme {
        StrideSnackBar(
            snackbarData = object : SnackbarData {
                override val visuals: SnackbarVisuals
                    get() = StrideSnackBarVisuals("Hello", false)

                override fun dismiss() {}

                override fun performAction() {}

            },
        )
    }
}


