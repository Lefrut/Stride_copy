package com.application.navigation.model

import androidx.compose.runtime.Composable
import com.application.home.navigation.HomeRoute
import kotlin.reflect.KClass


val BottomBarRoutes @Composable get() = listOf<KClass<out Any>>(
    HomeRoute::class
)