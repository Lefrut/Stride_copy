package com.application.home.components

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.resources.R

@Composable
fun NotificationIcon(hasNotification: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        modifier = modifier.requiredSize(34.dp),
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier
                .size(25.dp)
                .drawWithContent {
                    if (hasNotification) {
                        drawCircle(
                            radius = 2.dp.toPx(),
                            color = Color(0xFFFF0000),
                            center = Offset(size.width - 3.dp.toPx(), 2.dp.toPx())
                        )
                        drawContent()
                    }
                },
            painter = painterResource(R.drawable.notification_bell),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline
        )
    }
}