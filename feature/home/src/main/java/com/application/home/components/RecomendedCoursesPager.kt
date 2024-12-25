package com.application.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.application.common_ui.preview.DarkPreview
import com.application.common_ui.text.ratingFormat
import com.application.home.model.RecommendedCourseUi
import com.application.resources.R
import com.application.ui.components.StrideCard
import com.application.ui.theme.StrideTheme
import com.application.ui.theme.bodyVerySmall
import com.application.ui.theme.labelVerySmall
import com.application.ui.theme.titleVerySmall

@Composable
fun RecommendedCoursesPager(
    modifier: Modifier = Modifier,
    recommendedCourses: List<RecommendedCourseUi> = testRecommendedCourses
) {

    val chunkedList = remember { recommendedCourses.chunked(3) }
    val pageWidth = (LocalConfiguration.current.screenWidthDp * 0.83).dp
    val density = LocalDensity.current

    var pagerHeight by remember {
        mutableStateOf(0.dp)
    }

    HorizontalPager(
        modifier = modifier,
        state = rememberPagerState { chunkedList.count() },
        pageSpacing = 20.dp,
        beyondViewportPageCount = 3,
        pageSize = PageSize.Fixed(pageWidth),
        key = { i -> chunkedList[i].joinToString { it.id.toString() } },
        snapPosition = SnapPosition.Center,
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) { i ->
        Box(
            modifier = Modifier
                .sizeIn(minHeight = pagerHeight)
                .onSizeChanged { card ->
                    val cardHeight = with(density) { card.height.toDp() }
                    if (cardHeight > pagerHeight) {
                        pagerHeight = cardHeight
                    }
                }, contentAlignment = Alignment.TopStart
        ) {
            RecommendedCoursesCard(
                recommendedCourses = chunkedList[i],
                onRecommendedCourseClick = { })
        }
    }
}

@Composable
private fun RecommendedCoursesCard(
    modifier: Modifier = Modifier,
    recommendedCourses: List<RecommendedCourseUi>,
    onRecommendedCourseClick: (RecommendedCourseUi) -> Unit,
) {
    StrideCard(
        modifier = modifier,
        onClick = {},
    ) {
        recommendedCourses.forEach { course ->
            RecommendedCourseItem(
                modifier = Modifier
                    .clickable(onClick = { onRecommendedCourseClick(course) })
                    .padding(vertical = 15.dp)
                    .fillMaxWidth(),
                course = course,
            )
            if (recommendedCourses.last() != course) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
    }
}


@DarkPreview
@Composable
private fun RecommendedCoursesPagerPreview() {
    StrideTheme {
        RecommendedCoursesPager()
    }
}

@Composable
private fun RecommendedCourseItem(
    modifier: Modifier = Modifier,
    course: RecommendedCourseUi,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 15.dp)
            .padding(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = course.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.FillBounds
        )
        Spacer(Modifier.width(15.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = course.title,
                style = MaterialTheme.typography.titleVerySmall,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 10.dp)
            ) {

                val bodyVerySmall = MaterialTheme.typography.bodyVerySmall

                Text(
                    text = stringResource(R.string.coach_name, course.coachName),
                    style = bodyVerySmall.copy(lineHeight = bodyVerySmall.fontSize),
                    color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
                )


                Icon(
                    painter = painterResource(R.drawable.star),
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(7.dp)
                        .align(Alignment.CenterVertically),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = ratingFormat(course.rating),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelVerySmall
                )
            }
        }
        Spacer(Modifier.width(22.dp))
        Icon(
            painter = painterResource(R.drawable.arrow_right),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )

    }
}

private val testRecommendedCourses = listOf(
    RecommendedCourseUi(
        id = 1,
        imageUrl = "https://example.com/course1.jpg",
        title = "Introduction to Kotlin Programming",
        coachId = 101,
        coachName = "John Doe",
        rating = 4.5f
    ),
    RecommendedCourseUi(
        id = 2,
        imageUrl = "https://example.com/course2.jpg",
        title = "Advanced Android Development",
        coachId = 102,
        coachName = "Jane Smith",
        rating = 4f

    ),
    RecommendedCourseUi(
        id = 3,
        imageUrl = "https://example.com/course3.jpg",
        title = "Mastering Jetpack Compose",
        coachId = 103,
        coachName = "Emily Brown",
        rating = 4.9f
    ),
    RecommendedCourseUi(
        id = 4,
        imageUrl = "https://example.com/course4.jpg",
        title = "Building RESTful APIs with Ktor",
        coachId = 104,
        coachName = "Michael Lee",
        rating = 4.2f
    ),
    RecommendedCourseUi(
        id = 5,
        imageUrl = "https://example.com/course5.jpg",
        title = "Coroutines and Flow in Kotlin",
        coachId = 105,
        coachName = "Sophia Green",
        rating = 4.7f
    ),
    RecommendedCourseUi(
        id = 24454,
        imageUrl = "https://example.com/course2.jpg",
        title = "Advanced Android Development",
        coachId = 102,
        coachName = "Jane Smith",
        rating = 4f

    ),
    RecommendedCourseUi(
        id = 1111,
        imageUrl = "https://example.com/course3.jpg",
        title = "Mastering Jetpack Compose",
        coachId = 103,
        coachName = "Emily Brown",
        rating = 4.9f
    ),
    RecommendedCourseUi(
        id = 43,
        imageUrl = "https://example.com/course4.jpg",
        title = "Building RESTful APIs with Ktor",
        coachId = 104,
        coachName = "Michael Lee",
        rating = 4.2f
    ),
    RecommendedCourseUi(
        id = 531,
        imageUrl = "https://example.com/course5.jpg",
        title = "Coroutines and Flow in Kotlin",
        coachId = 105,
        coachName = "Sophia Green",
        rating = 4.7f
    ),
)
