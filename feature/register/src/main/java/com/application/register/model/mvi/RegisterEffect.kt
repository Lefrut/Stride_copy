package com.application.register.model.mvi;

sealed interface RegisterEffect {
    data object NavigateToLogin : RegisterEffect
    data object NavigateToHome : RegisterEffect

    data class ShowSnackBar(val message: String, val isSuccess: Boolean) : RegisterEffect
}