package com.application.home.model

import androidx.compose.runtime.Immutable


@Immutable
data class RecommendedCourseUi(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val coachId: Int,
    val coachName: String,
    val rating: Float,
)
