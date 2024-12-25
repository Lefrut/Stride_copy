package com.application.stride_api.model.user

import kotlinx.serialization.Serializable

@Serializable
data class PhoneAndPassword(
    val phone: String,
    val password: String
)
