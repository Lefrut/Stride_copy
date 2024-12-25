package com.application.stride_api.model.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class MeDTO(
    @SerialName("email")
    val email: String? = null,
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("is_coach")
    val isCoach: Boolean? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("token")
    val token: String? = null
)