package com.application.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.application.resources.R

private val montserratFontFamily = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_bold, FontWeight.Bold),
)

private val commissionerFontFamily = FontFamily(
    Font(R.font.commissioner_bold, FontWeight.Bold),
    Font(R.font.commissioner_medium, FontWeight.Medium),
    Font(R.font.commissioner_semibold, FontWeight.SemiBold),
)

private val sfProRoundedFontFamily = FontFamily(
    Font(R.font.sf_pro_rounded_regular, FontWeight.Normal),
    Font(R.font.sf_pro_rounded_semibold, FontWeight.SemiBold),
)

val Typography = Typography(
    displaySmall = TextStyle(
        fontFamily = montserratFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.5.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    titleMedium = TextStyle(
        fontFamily = commissionerFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 30.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    labelMedium = TextStyle(
        fontSize = 13.sp,
        lineHeight = 20.sp,
        fontFamily = commissionerFontFamily,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    bodySmall = TextStyle(
        fontSize = 15.sp,
        lineHeight = 40.sp,
        fontFamily = sfProRoundedFontFamily,
        fontWeight = FontWeight.Normal,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    labelLarge = TextStyle(
        fontSize = 13.sp,
        lineHeight = 24.sp,
        fontFamily = commissionerFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    titleSmall = TextStyle(
        fontSize = 20.sp,
        lineHeight = 40.sp,
        fontFamily = commissionerFontFamily,
        fontWeight = FontWeight.Bold,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    labelSmall = TextStyle(
        fontSize = 8.sp,
        fontFamily = commissionerFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )
)

val LocalTypographyType = staticCompositionLocalOf<TypographyType> {
    TypographyType.Stride
}

interface TypographyType {
    data object Stride : TypographyType
}

@Composable
fun appTextStyles(vararg typesWithTextStyles: Pair<TypographyType, TextStyle>): TextStyle {
    val typographyType = LocalTypographyType.current
    return typesWithTextStyles.first { it.first == typographyType }.second
}

fun TextStyle.withStrideType(): Pair<TypographyType, TextStyle> {
    return TypographyType.Stride to this
}


val Typography.labelVerySmall: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
            fontSize = 6.sp,
            fontFamily = commissionerFontFamily,
            fontWeight = FontWeight.Bold,
        ).withStrideType()
    )

val Typography.titleVerySmall: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
            fontSize = 15.sp,
            fontFamily = commissionerFontFamily,
            fontWeight = FontWeight.Bold,
        ).withStrideType()
)

val Typography.bodySmallLow: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
            fontSize = 13.sp,
            lineHeight = 40.sp,
            fontFamily = sfProRoundedFontFamily,
            fontWeight = FontWeight.Normal,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None
            )
        ).withStrideType()
    )

val Typography.bodyVerySmall: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
            fontSize = 11.sp,
            lineHeight = 40.sp,
            fontFamily = sfProRoundedFontFamily,
            fontWeight = FontWeight.Normal,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None
            )
        ).withStrideType()
    )
val Typography.labelLargeLow: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
        fontSize = 12.sp,
        lineHeight = 24.sp,
        fontFamily = commissionerFontFamily,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
        ).withStrideType()
    )
val Typography.labelMediumLow: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
        fontSize = 12.sp,
        lineHeight = 24.sp,
        fontFamily = commissionerFontFamily,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
        ).withStrideType()
    )
val Typography.titleMediumVariant: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
        fontFamily = sfProRoundedFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 25.sp,
        lineHeight = 30.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
        ).withStrideType()
    )


val Typography.labelSmallHigh: TextStyle
    @Composable
    get() = appTextStyles(
        TextStyle(
            fontFamily = commissionerFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            lineHeight = 12.sp,
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None
            )
        ).withStrideType()
    )