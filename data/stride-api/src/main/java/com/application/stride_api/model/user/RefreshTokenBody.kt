package com.application.stride_api.model.user

import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenBody(
    val refresh: String
)