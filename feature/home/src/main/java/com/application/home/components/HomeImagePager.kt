package com.application.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.common_ui.preview.DarkPreview
import com.application.resources.R
import com.application.ui.theme.StrideTheme

@Composable
fun HomeImagePager(modifier: Modifier = Modifier) {
    val count = TestImages.count()

    val pageWidth = (LocalConfiguration.current.screenWidthDp * 0.8).dp

    HorizontalPager(
        state = rememberPagerState(count/2) { count },
        pageSize = PageSize.Fixed(pageWidth),
        pageSpacing = 12.dp,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        snapPosition = SnapPosition.Center,
        beyondViewportPageCount = 10
    ) { page ->
        Image(
            modifier = Modifier
                .height(180.dp)
                .clip(MaterialTheme.shapes.medium),
            painter = painterResource(id = TestImages[page]),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

private val TestImages @Composable get() = List(10) { R.drawable.intro_background }


@DarkPreview
@Composable
private fun HomeImageCarouselPreview() {
    StrideTheme {
        HomeImagePager()
    }
}