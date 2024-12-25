package com.application.register.model.mvi;

sealed class RegisterState {

    data class Success(
        val phone: String = "",
        val password: String = "",
        val confirmPassword: String = "",
        val showPassword: Boolean = false,
        val name: String = "",
        val surname: String = "",
        val email: String = "",
    ): RegisterState()

}