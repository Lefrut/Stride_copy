package com.application.start.model.mvi

sealed interface StartEffect {
    data object NavigateToLogin : StartEffect

    data object NavigateToRegister : StartEffect

}