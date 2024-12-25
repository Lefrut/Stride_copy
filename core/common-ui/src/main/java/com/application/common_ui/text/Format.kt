package com.application.common_ui.text

import java.util.Locale


fun ratingFormat(rating: Float): String{
    return String.format(Locale.getDefault(), "%.1f", rating)
}