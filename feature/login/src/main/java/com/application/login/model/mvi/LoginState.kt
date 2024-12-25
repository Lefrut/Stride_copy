package com.application.login.model.mvi;

sealed class LoginState {

    data class Success(
        val phone: String = "",
        val password: String = "",
        val showPassword: Boolean = false,
    ): LoginState()

}