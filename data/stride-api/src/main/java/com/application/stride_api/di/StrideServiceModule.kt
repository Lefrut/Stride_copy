package com.application.stride_api.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import com.application.stride.repository.UserRepository
import com.application.stride_api.ktor.UserService
import com.application.stride_api.ktor.UserServiceImpl
import com.application.stride_api.mappers.ServiceMappers
import com.application.stride_api.mappers.ServiceMappersImpl
import com.application.stride_api.model.user.AccessTokenDTO
import com.application.stride_api.model.user.RefreshTokenBody
import com.application.stride_api.prefereces.TokenManager
import com.application.stride_api.prefereces.TokenManagerImpl
import com.application.stride_api.repository.UserRepositoryImpl
import io.github.osipxd.security.crypto.createEncrypted
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.addDefaultResponseValidation
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.first
import kotlinx.serialization.json.Json
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val serviceStrideModule = module {

    singleOf(::TokenManagerImpl) bind TokenManager::class

    single { provideClient(get<TokenManager>()) }

    single { provideDatastore(androidApplication()) }

    singleOf(::UserServiceImpl) bind UserService::class

    singleOf(::ServiceMappersImpl) bind ServiceMappers::class

    singleOf(::UserRepositoryImpl) bind UserRepository::class


}

private const val BASE_URL = "http://localhost:8000/api/v1/"


private fun provideDatastore(context: Context): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createEncrypted {
        EncryptedFile.Builder(
            context.dataStoreFile("tokens.preferences_pb"),
            context,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()
    }
}


private fun provideClient(tokenManager: TokenManager): HttpClient {
    return HttpClient(CIO) {

        install(ContentNegotiation) {
            json(
                Json { ignoreUnknownKeys = true }
            )
        }

        expectSuccess = true

        install(Auth) {
            bearer {
                loadTokens {
                    val refreshToken = tokenManager.refreshToken.first()
                    val accessToken = tokenManager.accessToken.first()
                    BearerTokens(accessToken, refreshToken)
                }

                refreshTokens {
                    val refreshToken = tokenManager.refreshToken.first()

                    val accessTokenDTO = client.post {
                        markAsRefreshTokenRequest()
                        url.path("/api/token/refresh/")
                        setBody(RefreshTokenBody(refreshToken))
                    }.body<AccessTokenDTO>()

                    val accessToken =
                        accessTokenDTO.access
                            ?: throw IllegalArgumentException("Access token not provided after refresh operation")

                    tokenManager.updateAccessToken(accessToken)

                    BearerTokens(
                        accessToken = accessToken,
                        refreshToken = refreshToken
                    )
                }
            }
        }


        addDefaultResponseValidation()

        install(Logging) {
            level = if (BuildConfig.DEBUG) LogLevel.ALL else LogLevel.NONE
            logger = Logger.DEFAULT
        }

        defaultRequest { url(BASE_URL) }


    }
}