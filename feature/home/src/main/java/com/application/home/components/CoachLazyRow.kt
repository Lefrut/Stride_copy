package com.application.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.application.common_ui.preview.DarkPreview
import com.application.ui.components.StrideCard
import com.application.ui.model.CoachLiteUi
import com.application.ui.theme.StrideTheme
import com.application.ui.theme.labelMediumLow
import com.application.ui.theme.labelSmallHigh

@Composable
fun CoachLazyRow(modifier: Modifier = Modifier, coaches: List<CoachLiteUi> = TestCoaches) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(coaches) { coach ->
            CoachItem(coach = coach, onClick = {  })
        }
    }
}


@Composable
private fun CoachItem(
    modifier: Modifier = Modifier,
    coach: CoachLiteUi,
    onClick: (CoachLiteUi) -> Unit
) {
    StrideCard(
        modifier = modifier,
        onClick = {
            onClick(coach)
        },
        contentPadding = PaddingValues(
            top = 5.dp,
            start = 5.dp,
            end = 5.dp,
            bottom = 7.dp
        )
    ) {
        AsyncImage(
            model = coach.imageUrl,
            contentDescription = null,
            modifier = Modifier.width(95.dp).height(80.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = coach.name,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelSmallHigh
        )
        Row {

        }
    }
}


@DarkPreview
@Composable
private fun CoachLazyRowPreview() {
    StrideTheme {
        CoachLazyRow()
    }
}

private val TestCoaches
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

