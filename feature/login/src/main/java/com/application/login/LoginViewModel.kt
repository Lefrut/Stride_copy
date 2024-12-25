package com.application.login;

import com.application.common.phone.isPhoneNumberValid
import com.application.common.resources.ResourcesProvider
import com.application.common_ui.mvi.MviViewModel
import com.application.login.model.mvi.LoginEffect
import com.application.login.model.mvi.LoginState
import com.application.resources.R
import com.application.stride.model.LoginExceptions
import com.application.stride.repository.UserRepository
import org.orbitmvi.orbit.syntax.Syntax

class LoginViewModel(
    private val userRepository: UserRepository,
    private val resourcesProvider: ResourcesProvider
) : MviViewModel<LoginState, LoginEffect>(LoginState.Success()) {


    fun login() = intent {
        val state = state as? LoginState.Success ?: return@intent

        if (!isPhoneAndPasswordValid(state)) {
            return@intent
        }

        userRepository.signInUser(
            phone = state.phone,
            password = state.password
        ).collect { result ->
            result.onSuccess {
                postSideEffect(LoginEffect.NavigateToHome)
            }
            result.onFailure { throwable ->
                val message = throwable.mapToLoginMessage()
                postSideEffect(LoginEffect.ShowError(message))
            }
        }

    }

    private fun Throwable.mapToLoginMessage(): String{
        return when (this) {
            is LoginExceptions.InputException -> {
                resourcesProvider.getString(R.string.error_invalid_input)
            }
            else -> resourcesProvider.getString(R.string.unknown_error)
        }
    }


    private suspend fun Syntax<LoginState, LoginEffect>.isPhoneAndPasswordValid(state: LoginState.Success): Boolean {
        if (!isPhoneNumberValid(state.phone)) {
            postSideEffect(LoginEffect.ShowError(resourcesProvider.getString(R.string.error_invalid_phone)))
            return false
        } else if (state.password.length < 8) {
            postSideEffect(LoginEffect.ShowError(resourcesProvider.getString(R.string.error_short_password)))
            return false
        }
        return true
    }




    fun changePhone(newPhone: String) = intent {
        val state = state as? LoginState.Success ?: return@intent
        reduce {
            state.copy(phone = newPhone)
        }
    }

    fun changePassword(newPassword: String) = intent {
        val state = state as? LoginState.Success ?: return@intent
        reduce {
            state.copy(password = newPassword)
        }
    }

    fun showPassword(newShowPassword: Boolean) = intent {
        val state = state as? LoginState.Success ?: return@intent
        reduce {
            state.copy(showPassword = newShowPassword)
        }
    }

    fun clickRegister() = intent {
        postSideEffect(LoginEffect.NavigateToRegister)
    }
}