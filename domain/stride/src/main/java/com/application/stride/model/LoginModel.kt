package com.application.stride.model

data class LoginModel(
    val email: String,
    val phone: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val passwordAgain: String,
)
