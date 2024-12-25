package com.application.stride_api.prefereces

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

interface TokenManager {

    val refreshToken: Flow<String>

    val accessToken: Flow<String>

    val userId: Flow<Int>

    suspend fun updateAll(refreshToken: String, accessToken: String, userId: Int)

    suspend fun updateRefreshToken(refreshToken: String)

    suspend fun updateAccessToken(accessToken: String)

    suspend fun updateUserId(userId: Int)

    val sessionInfo: Flow<SessionInfo>
        get() = combine(
            refreshToken,
            accessToken,
            userId
        ) { refreshToken, accessToken, userId ->
            SessionInfo(
                refreshToken = refreshToken,
                accessToken = accessToken,
                userId = userId
            )
        }

}

data class SessionInfo(
    val refreshToken: String,
    val accessToken: String,
    val userId: Int
)