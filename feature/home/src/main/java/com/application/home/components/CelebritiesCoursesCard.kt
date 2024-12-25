package com.application.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.application.common_ui.preview.DarkPreview
import com.application.common_ui.text.ratingFormat
import com.application.resources.R
import com.application.ui.components.StrideCard
import com.application.ui.model.CoachLiteUi
import com.application.ui.theme.StrideTheme
import com.application.ui.theme.bodyVerySmall
import com.application.ui.theme.labelVerySmall

@Composable
fun CelebritiesCoursesCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    celebrities: List<CoachLiteUi> = testCelebrities
) {

    StrideCard(modifier = modifier.fillMaxWidth(), onClick = onClick) {
        Row(
            Modifier
                .padding(vertical = 15.dp)
                .padding(start = 20.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1.1f)) {
                val titleSmall = MaterialTheme.typography.titleSmall
                Text(
                    text = stringResource(R.string.courses_from_celebrities),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = titleSmall.copy(lineHeight = titleSmall.fontSize)
                )
                HorizontalDivider(
                    modifier = Modifier.padding(top = 9.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = stringResource(R.string.courses_from_celebrities),
                    color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                    style = MaterialTheme.typography.bodyVerySmall
                )
            }

            Spacer(Modifier.width(13.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        MaterialTheme.shapes.medium
                    )
                    .padding(horizontal = 11.dp)
                    .padding(top = 12.dp, bottom = 14.dp),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                celebrities.forEach { celebrity ->
                    CelebrityCardItem(
                        modifier = Modifier.fillMaxWidth(),
                        celebrity = celebrity
                    )
                }
            }
        }
    }
}

@Composable
fun CelebrityCardItem(
    modifier: Modifier = Modifier,
    celebrity: CoachLiteUi
) {
    Row(modifier = modifier, verticalAlignment = Alignment.Bottom) {
        SubcomposeAsyncImage(
            model = celebrity.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier.size(15.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    strokeWidth = 2.dp,
                    trackColor = Color.Transparent
                )
            },
            error = {
                Image(
                    painter = painterResource(R.drawable.base_avatar),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.Crop
                )
            }
        )

        val labelSmall = with(MaterialTheme.typography.labelSmall) { copy(lineHeight = lineHeight) }
        Box(modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .width(IntrinsicSize.Max)
            ) {
                Text(
                    text = celebrity.name,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                HorizontalDivider(
                    modifier = Modifier.padding(top = 5.dp),
                    thickness = 0.5.dp,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.4f)
                )
            }
        }
        Icon(
            painter = painterResource(R.drawable.star),
            modifier = Modifier
                .size(7.dp)
                .align(Alignment.CenterVertically),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier
                .padding(start = 2.dp)
                .align(Alignment.CenterVertically),
            text = ratingFormat(celebrity.rate),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.labelVerySmall
        )
    }
}

@DarkPreview
@Composable
private fun CelebritiesCoursesCardPreview() {
    StrideTheme {
        CelebritiesCoursesCard(onClick = {})
    }
}

private val testCelebrities
    @Composable get() = remember {
        listOf(
            CoachLiteUi(
                id = 1,
                name = "John Smith",
                imageUrl = "https://example.com/images/john_smith.jpg",
                rate = 5f
            ),
            CoachLiteUi(
                id = 2,
                name = "Emily Johnson",
                imageUrl = "https://example.com/images/emily_johnson.jpg",
                rate = 4.3f
            ),
            CoachLiteUi(
                id = 3,
                name = "Michael Brown",
                imageUrl = "https://example.com/images/michael_brown.jpg",
                rate = 3.92f
            )
        )
    }