package com.application.stride_api.ktor

import com.application.stride_api.model.user.MeDTO
import com.application.stride_api.model.user.TokenDTO
import com.application.stride_api.model.user.RegisterDTO
import com.application.stride_api.model.user.UserWithTokenDTO
import kotlinx.coroutines.flow.Flow

interface UserService {

    fun signUpUser(
        registerDTO: RegisterDTO,
    ): Flow<UserWithTokenDTO>


    fun signInUser(
        phone: String,
        password: String
    ): Flow<TokenDTO>

    fun getMe(): Flow<MeDTO>

}