package com.application.stride_api.prefereces

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenManagerImpl(
    private val dataStore: DataStore<Preferences>
) : TokenManager {

    override val refreshToken: Flow<String>
        get() = dataStore.data.map { pref -> pref[Keys.refreshToken] ?: "" }
    override val accessToken: Flow<String>
        get() = dataStore.data.map { pref -> pref[Keys.accessToken] ?: "" }
    override val userId: Flow<Int>
        get() = dataStore.data.map { pref -> pref[Keys.userId] ?: NO_FOUND_USER_ID }

    override suspend fun updateAll(refreshToken: String, accessToken: String, userId: Int) {
        dataStore.edit { preferences ->
            preferences[Keys.refreshToken] = refreshToken
            preferences[Keys.accessToken] = accessToken
            preferences[Keys.userId] = userId
        }
    }

    override suspend fun updateRefreshToken(refreshToken: String) {
        dataStore.edit { preferences ->
            preferences[Keys.refreshToken] = refreshToken
        }
    }

    override suspend fun updateAccessToken(accessToken: String) {
        dataStore.edit { preferences ->
            preferences[Keys.accessToken] = accessToken
        }
    }

    override suspend fun updateUserId(userId: Int) {
        dataStore.edit { preferences ->
            preferences[Keys.userId] = userId
        }
    }

    private data object Keys {
        val refreshToken = stringPreferencesKey("refreshToken")
        val accessToken = stringPreferencesKey("accessToken")
        val userId = intPreferencesKey("userId")
    }

    companion object {
        const val NO_FOUND_USER_ID = -1
    }

}