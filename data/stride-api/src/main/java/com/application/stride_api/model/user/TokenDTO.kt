package com.application.stride_api.model.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class TokenDTO(
    @SerialName("access")
    val access: String? = null,
    @SerialName("refresh")
    val refresh: String? = null
)