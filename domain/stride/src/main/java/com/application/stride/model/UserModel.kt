package com.application.stride.model

data class UserModel(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val isCoach: Boolean
)
