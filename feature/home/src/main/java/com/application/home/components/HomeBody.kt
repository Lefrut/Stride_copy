package com.application.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.application.resources.R
import com.application.ui.theme.titleVerySmall

@Composable
internal fun HomeBody(modifier: Modifier = Modifier) = Column(
    modifier = modifier.verticalScroll(rememberScrollState())
) {
    HomeImagePager(
        modifier = Modifier.padding(bottom = 28.dp)
    )

    Column(modifier = Modifier.padding(horizontal = 15.dp)) {

        CelebritiesCoursesCard(
            onClick = {

            }
        )
        Row(modifier = Modifier.padding(top = 7.dp)) {
            PopularCoursesCard(
                onClick = {

                },
                views = 1000,
                rating = 4.5f,
                countCourses = 17
            )
            Spacer(Modifier.width(5.dp))
            MyCoursesCard(
                modifier = Modifier.weight(1f),
                onClick = {

                }
            )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .padding(top = 35.dp)
        ) {
            Text(
                text = stringResource(R.string.recommended_courses),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleVerySmall.copy(fontSize = 16.sp),
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = stringResource(R.string.all),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleVerySmall.copy(fontWeight = FontWeight.SemiBold)
            )
        }

    }
    RecommendedCoursesPager(
        modifier = Modifier.padding(top = 17.dp)
    )
    Text(
        modifier = Modifier
            .padding(horizontal = 25.dp)
            .padding(top = 30.dp),
        text = stringResource(R.string.coach),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.titleVerySmall,
    )

    CoachLazyRow()

    Spacer(Modifier.height(140.dp))
}

