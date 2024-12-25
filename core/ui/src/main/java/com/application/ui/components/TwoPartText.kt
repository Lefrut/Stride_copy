package com.application.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import com.application.resources.R
import com.application.ui.theme.bodySmallLow

@Composable
fun TwoPartText(
    text: String,
    clickableText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = buildTwoPartAnnotatedString(text, clickableText, onClick),
        modifier = modifier
    )
}


@Composable
private fun buildTwoPartAnnotatedString(
    text: String,
    clickableText: String,
    onClick: () -> Unit
): AnnotatedString {
    return buildAnnotatedString {
        withStyle(
            style = MaterialTheme.typography.bodySmallLow.copy(
                color = MaterialTheme.colorScheme.onBackground.copy(
                    0.7f
                )
            ).toSpanStyle()
        ) {
            append(text)
            append(stringResource(R.string.space))
        }

        withLink(
            LinkAnnotation.Clickable(
                tag = "ClickableText",
                styles = TextLinkStyles(
                    style = MaterialTheme.typography.bodySmallLow.copy(
                        color = MaterialTheme.colorScheme.onBackground.copy(
                            0.9f
                        )
                    ).toSpanStyle(),
                ),
                linkInteractionListener = { onClick() })
        ) {
            append(clickableText)
        }
    }
}