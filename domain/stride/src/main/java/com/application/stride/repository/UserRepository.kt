package com.application.stride.repository

import com.application.stride.model.LoginModel
import com.application.stride.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {


    fun signUpUser(loginModel: LoginModel): Flow<Result<UserModel>>

    fun signInUser(phone: String, password: String): Flow<Result<UserModel>>


}