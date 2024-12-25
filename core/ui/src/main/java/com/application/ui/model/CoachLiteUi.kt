package com.application.ui.model

import androidx.compose.runtime.Immutable

@Immutable
class CoachLiteUi(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val rate: Float,
)