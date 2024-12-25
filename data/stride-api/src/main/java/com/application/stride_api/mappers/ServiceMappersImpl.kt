package com.application.stride_api.mappers

import com.application.stride.model.LoginModel
import com.application.stride.model.UserModel
import com.application.stride_api.model.user.MeDTO
import com.application.stride_api.model.user.RegisterDTO
import com.application.stride_api.model.user.UserWithTokenDTO

class ServiceMappersImpl : ServiceMappers {

    override fun mapLoginModelToUserBody(loginModel: LoginModel): RegisterDTO {
        return RegisterDTO(
            email = loginModel.email,
            firstName = loginModel.firstName,
            lastName = loginModel.lastName,
            password = loginModel.password,
            passwordAgain = loginModel.passwordAgain,
            phoneNumber = loginModel.phone,
        )
    }

    override fun mapUseUserWithTokenDTOtoUserModel(userWithTokenDTO: UserWithTokenDTO): UserModel {
        return UserModel(
            id = userWithTokenDTO.id ?: throw IllegalArgumentException("User ID cannot be null"),
            email = userWithTokenDTO.email ?: throw IllegalArgumentException("Email cannot be null"),
            firstName = userWithTokenDTO.firstName ?: throw IllegalArgumentException("First name cannot be null"),
            lastName = userWithTokenDTO.lastName ?: throw IllegalArgumentException("Last name cannot be null"),
            phone = userWithTokenDTO.phoneNumber ?: throw IllegalArgumentException("Phone number cannot be null"),
            isCoach = userWithTokenDTO.isCoach ?: throw IllegalArgumentException("isCoach flag cannot be null")
        )
    }

    override fun mapMeDTOtoUserModel(meDTO: MeDTO): UserModel {
        return UserModel(
            id = meDTO.id ?: throw IllegalArgumentException("User ID cannot be null"),
            email = meDTO.email ?: throw IllegalArgumentException("Email cannot be null"),
            firstName = meDTO.firstName ?: throw IllegalArgumentException("First name cannot be null"),
            lastName = meDTO.lastName ?: "",
            phone = meDTO.phoneNumber ?: "",
            isCoach = meDTO.isCoach ?: false
        )
    }


}