package com.application.home;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.application.home.model.mvi.HomeEffect
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun HomeRoute() {
    val viewModel = koinViewModel<HomeViewModel>()
    val viewState by viewModel.collectAsState()

    HomeScreen(
        viewState = viewState,
    )

    viewModel.collectSideEffect { effect ->
        when(effect){
            else -> {

            }
        }
    }
}