package com.application.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


private val DarkColorScheme = darkColorScheme(
    primary = PrimaryLightBlue100,
    onBackground = White,
    outline = OutlineWhite75,
    scrim = ScrimDarkBlue70,
    outlineVariant = OutlineVariantGrey100,
    background = BackgroundDarkBlue100,
    surface = SurfaceDarkGreyBlue100,
    surfaceDim = SurfaceDimDarkGreyBlue100,
    surfaceVariant = SurfaceVariantLightGreyBlue100,
    onSurfaceVariant = Color(0xFF556170),
    error = ErrorRed
)

val ColorScheme.success @Composable get() = materialColor(SuccessGreen, SuccessGreen)


private val LightColorScheme = lightColorScheme(
)

@Composable
fun StrideTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes
    ) {
        Scaffold { padding ->
            Box(Modifier.padding(padding)) {
                content()
            }
        }
    }
}