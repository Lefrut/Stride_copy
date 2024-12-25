package com.application.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.application.common_ui.preview.DarkPreview
import com.application.resources.R
import com.application.ui.theme.StrideTheme
import com.application.ui.theme.bodyVerySmall

@Composable
fun HomeTitle(modifier: Modifier = Modifier, username: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.base_avatar),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(Modifier.width(13.dp))

        Column {
            Text(
                text = stringResource(R.string.welcome_back),
                color = MaterialTheme.colorScheme.onBackground.copy(0.8f),
                style = MaterialTheme.typography.bodyVerySmall.copy(
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Bottom,
                        LineHeightStyle.Trim.FirstLineTop
                    )
                )
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = username,
                color = MaterialTheme.colorScheme.onBackground.copy(0.9f),
                style = MaterialTheme.typography.bodySmall.copy(
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Bottom,
                        LineHeightStyle.Trim.FirstLineTop
                    )
                )
            )
        }

        Spacer(Modifier.weight(1f))

        NotificationIcon(hasNotification = true) { }
    }

}


@Composable
@DarkPreview
private fun HomeTitlePreview() {
    StrideTheme {
        HomeTitle(username = "Кирилл")
    }
}

