package com.application.stride_api.model.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class AccessTokenDTO(
    @SerialName("access")
    val access: String? = null
)