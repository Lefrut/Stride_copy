package com.application.stride_api.ktor

import com.application.stride_api.model.user.MeDTO
import com.application.stride_api.model.user.PhoneAndPassword
import com.application.stride_api.model.user.TokenDTO
import com.application.stride_api.model.user.RegisterDTO
import com.application.stride_api.model.user.UserWithTokenDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserServiceImpl(
    private val client: HttpClient
): UserService {

    override fun signUpUser(registerDTO: RegisterDTO): Flow<UserWithTokenDTO> = flow {
        val response = client.post {
            url.appendPathSegments("users")
            contentType(ContentType.Application.Json)
            setBody<RegisterDTO>(registerDTO)
        }

        val userWithTokenDTO = response.body<UserWithTokenDTO>()
        emit(userWithTokenDTO)
    }

    override fun signInUser(phone: String, password: String): Flow<TokenDTO> = flow {
        val response = client.post {
            url.path("api/token")
            contentType(ContentType.Application.Json)
            setBody(PhoneAndPassword(phone,password))
        }
        val tokenDTO = response.body<TokenDTO>()
        emit(tokenDTO)
    }

    override fun getMe(): Flow<MeDTO> = flow {
        val response = client.get {
            url.appendPathSegments("users/me")
        }
        val userDTO = response.body<MeDTO>()
        emit(userDTO)
    }
}