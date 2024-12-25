package com.application.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.application.common_ui.preview.DarkPreview
import com.application.common_ui.text.ratingFormat
import com.application.resources.R
import com.application.ui.components.StrideCard
import com.application.ui.theme.StrideTheme
import com.application.ui.theme.labelVerySmall
import com.application.ui.theme.titleVerySmall

@Composable
fun PopularCoursesCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    views: Int,
    rating: Float,
    countCourses: Int
) {
    StrideCard(
        modifier = modifier.height(64.dp),
        onClick = onClick,
        contentPadding = PaddingValues(start = 18.dp, top = 17.dp, end = 12.dp)
    ) {
        Text(
            text = stringResource(R.string.popular_courses),
            style = MaterialTheme.typography.titleVerySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Row(
            modifier = Modifier.padding(top = 13.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconWithText(iconId = R.drawable.eye_outline, text = views.toString())
            IconWithText(iconId = R.drawable.start_outline, text = ratingFormat(rating))
            IconWithText(iconId = R.drawable.study_outline, text = countCourses.toString())
        }
    }
}

@Composable
private fun IconWithText(
    modifier: Modifier = Modifier,
    iconId: Int,
    text: String
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.labelVerySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@DarkPreview
@Composable
private fun PopularCoursesCardPreview() {
    StrideTheme {
        PopularCoursesCard(
            onClick = {},
            views = 1000,
            rating = 4.5f,
            countCourses = 17
        )
    }
}