package com.application.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.resources.R
import com.application.ui.components.StrideCard

@Composable
fun MyCoursesCard(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val cardHeight = 64.dp

    StrideCard(
        modifier = modifier.height(cardHeight),
        onClick = {},
        contentPadding = PaddingValues(start = 15.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier.height(cardHeight),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(bottom = 3.dp),
                text = stringResource(R.string.my_courses),
                style = MaterialTheme.typography.titleSmall.copy(fontSize = 17.sp),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.weight(1f))
            FilledIconButton(
                onClick = onClick,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape),
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.play),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}