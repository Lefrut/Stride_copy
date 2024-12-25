package com.application.home;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.home.components.CelebritiesCoursesCard
import com.application.home.components.HomeBody
import com.application.home.components.HomeImagePager
import com.application.home.components.HomeTitle
import com.application.home.components.MyCoursesCard
import com.application.home.components.PopularCoursesCard
import com.application.home.model.mvi.HomeState
import com.application.resources.R
import com.application.ui.theme.titleVerySmall

@Composable
fun HomeScreen(
    viewState: HomeState,
) {
    if (viewState is HomeState.Success) {
        HomeContent(
            username = viewState.username
        )
    }
}

@Composable
fun HomeContent(username: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        HomeTitle(modifier = Modifier.padding(top = 20.dp, bottom = 28.dp), username = username)
        HomeBody()
    }
}

