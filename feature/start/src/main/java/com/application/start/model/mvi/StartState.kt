package com.application.start.model.mvi


sealed class StartState {
    data object Success: StartState()
}