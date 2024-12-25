package com.application.stride_api.model.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class ErrorLoginDTO(
    @SerialName("email")
    val email: List<String?>? = null,
    @SerialName("password")
    val password: List<String?>? = null,
    @SerialName("phone_number")
    val phoneNumber: List<String?>? = null
)