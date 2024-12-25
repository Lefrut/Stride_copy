package com.application.stride_api.model.user


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterDTO(
    @SerialName("email")
    val email: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("is_coach")
    val isCoach: Boolean = false,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("password")
    val password: String,
    @SerialName("password_again")
    val passwordAgain: String,
    @SerialName("phone_number")
    val phoneNumber: String
)