package com.application.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

internal val Shapes = Shapes(
    large = RoundedCornerShape(25.dp),
    extraLarge = RoundedCornerShape(27.dp),
    medium = RoundedCornerShape(10.dp)
)

val Shapes.extraMedium: RoundedCornerShape
    get() = RoundedCornerShape(15.dp)