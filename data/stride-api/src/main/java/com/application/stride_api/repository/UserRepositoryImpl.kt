package com.application.stride_api.repository

import com.application.stride.model.LoginExceptions
import com.application.stride.model.LoginModel
import com.application.stride.model.RegisterExceptions
import com.application.stride.model.UserModel
import com.application.stride.repository.UserRepository
import com.application.stride_api.ktor.UserService
import com.application.stride_api.mappers.ServiceMappers
import com.application.stride_api.model.user.ErrorLoginDTO
import com.application.stride_api.prefereces.TokenManager
import io.ktor.client.call.body
import io.ktor.client.plugins.ResponseException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.zip

class UserRepositoryImpl(
    private val userService: UserService,
    private val tokenManager: TokenManager,
    private val mappers: ServiceMappers
) : UserRepository {

    override fun signUpUser(
        loginModel: LoginModel
    ): Flow<Result<UserModel>> =
        userService.signUpUser(mappers.mapLoginModelToUserBody(loginModel)).take(1)
            .onEach { userWithTokenDTO ->
                val tokenDTO =
                    userWithTokenDTO.token ?: throw IllegalArgumentException("Token cannot be null")

                tokenManager.updateAll(
                    accessToken = tokenDTO.access
                        ?: throw IllegalArgumentException("Access token cannot be null"),
                    refreshToken = tokenDTO.refresh
                        ?: throw IllegalArgumentException("Refresh token cannot be null"),
                    userId = userWithTokenDTO.id
                        ?: throw IllegalArgumentException("User id cannot be null")
                )

            }.map { userWithTokenDTO ->
                Result.success(mappers.mapUseUserWithTokenDTOtoUserModel(userWithTokenDTO))
            }.catch { throwable ->
                if (throwable is ResponseException && throwable.response.status == HttpStatusCode.BadRequest) {
                    val response = throwable.response
                    val errorLoginDTO = response.body<ErrorLoginDTO>()

                    if (errorLoginDTO.email?.isNotEmpty() == true) {
                        emit(Result.failure(RegisterExceptions.EmailAlreadyException()))
                    } else if (errorLoginDTO.password?.isNotEmpty() == true) {
                        emit(Result.failure(RegisterExceptions.SimplePasswordException()))
                    } else if (errorLoginDTO.phoneNumber?.isNotEmpty() == true) {
                        emit(Result.failure(RegisterExceptions.PhoneAlreadyException()))
                    }
                } else {
                    emit(Result.failure(throwable))
                }
            }.catch { throwable ->
                emit(Result.failure(throwable))
            }.flowOn(Dispatchers.IO)

    override fun signInUser(phone: String, password: String): Flow<Result<UserModel>> =
        userService.signInUser(phone, password).take(1).onEach { tokenDTO ->
            val (accessToken, refreshToken) = tokenDTO.run {
                (access ?: throw IllegalArgumentException("Access token cannot be null")) to
                        (refresh ?: throw IllegalArgumentException("Refresh token cannot be null"))
            }
            tokenManager.updateAccessToken(accessToken = accessToken)
            tokenManager.updateRefreshToken(refreshToken = refreshToken)
        }.catch { throwable ->
            if (throwable is ResponseException && throwable.response.status == HttpStatusCode.BadRequest) {
                throw LoginExceptions.InputException(throwable)
            }
        }.zip(userService.getMe()) { _, meDTO ->
            mappers.mapMeDTOtoUserModel(meDTO)
        }.map { userModel ->
            tokenManager.updateUserId(userModel.id)
            Result.success(userModel)
        }.catch { throwable ->
            emit(Result.failure(throwable))
        }
}