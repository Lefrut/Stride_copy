package com.application.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.application.resources.R
import com.application.ui.theme.StrideTheme
import com.application.ui.theme.labelMediumLow

@Composable
fun IntroPage(
    text: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    labelButtonText: String? = null,
    onLabelButtonClick: () -> Unit = {},
    label: String = stringResource(R.string.stride_slogan),
    title: String = stringResource(R.string.app_name),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.intro_background),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            .background(color = MaterialTheme.colorScheme.scrim)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        IntroTitle(
            modifier = Modifier.padding(top = 85.dp),
            text = title
        )

        Spacer(Modifier.weight(1f))


        Text(
            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            modifier = Modifier.padding(top = 19.dp),
            text = label,
            color = MaterialTheme.colorScheme.outline,
            style = MaterialTheme.typography.labelMedium
        )

        StrideOutlineButton(
            text = buttonText,
            textStyle = MaterialTheme.typography.labelMedium,
            onClink = onButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
        )

        Box(
            Modifier.padding(bottom = 10.dp)
        ) {
            if (labelButtonText != null) {
                StrideTextButton(
                    modifier = Modifier.padding(top = 15.dp),
                    onClick = onLabelButtonClick,
                    text = labelButtonText,
                    textStyle = MaterialTheme.typography.labelMediumLow,
                )
            }
        }

    }

}

@Composable
private fun IntroTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text.uppercase(),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.displaySmall
    )
}

@Preview
@Composable
private fun IntroPagePreview() {
    StrideTheme {
        IntroPage(
            text = stringResource(R.string.stride_slogan),
            buttonText = "",
            onButtonClick = {}
        )
    }
}