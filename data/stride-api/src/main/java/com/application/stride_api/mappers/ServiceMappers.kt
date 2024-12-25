package com.application.stride_api.mappers

import com.application.stride.model.LoginModel
import com.application.stride.model.UserModel
import com.application.stride_api.model.user.MeDTO
import com.application.stride_api.model.user.RegisterDTO
import com.application.stride_api.model.user.UserWithTokenDTO

interface ServiceMappers {
    fun mapLoginModelToUserBody(loginModel: LoginModel): RegisterDTO

    fun mapUseUserWithTokenDTOtoUserModel(
        userWithTokenDTO: UserWithTokenDTO
    ): UserModel

    fun mapMeDTOtoUserModel(
        meDTO: MeDTO
    ): UserModel
}