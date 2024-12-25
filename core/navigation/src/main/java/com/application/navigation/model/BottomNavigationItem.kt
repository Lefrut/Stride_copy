package com.application.navigation.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.application.home.navigation.HomeRoute
import kotlin.reflect.KClass
import com.application.resources.R

@Immutable
enum class BottomNavigationItem(
    @DrawableRes
    val iconId: Int,
    val routeClass: KClass<out Any>,
) {
    Home(R.drawable.home, HomeRoute::class),
    Catalog(R.drawable.catalog, Double::class),
    Courses(R.drawable.courses, Double::class),
    Profile(R.drawable.profile, Double::class),
}