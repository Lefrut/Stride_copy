package com.application.login.model.mvi;

sealed interface LoginEffect {
    data object NavigateToRegister : LoginEffect
    data object NavigateToHome : LoginEffect
    data class ShowError(val message: String): LoginEffect
}