package com.application.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun materialColor(
    lightColor: Color = Color.Unspecified,
    darkColor: Color = Color.Unspecified
): Color {
    return if (isSystemInDarkTheme()) {
        darkColor
    } else {
        lightColor
    }
}