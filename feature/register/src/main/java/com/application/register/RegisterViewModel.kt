package com.application.register;

import android.util.Log
import android.util.Patterns
import com.application.common.phone.isPhoneNumberValid
import com.application.common.resources.ResourcesProvider
import com.application.common_ui.mvi.MviViewModel
import com.application.register.model.mvi.RegisterEffect
import com.application.register.model.mvi.RegisterState
import com.application.resources.R
import com.application.stride.model.LoginModel
import com.application.stride.model.RegisterExceptions
import com.application.stride.repository.UserRepository
import kotlinx.coroutines.flow.single
import org.orbitmvi.orbit.syntax.Syntax


class RegisterViewModel(
    private val userRepository: UserRepository,
    private val resourcesProvider: ResourcesProvider
) : MviViewModel<RegisterState, RegisterEffect>(RegisterState.Success()) {


    fun switchToLogin() = intent {
        postSideEffect(RegisterEffect.NavigateToLogin)
    }

    fun changeName(newName: String) = intent {
        val state = state as? RegisterState.Success ?: return@intent
        reduce { state.copy(name = newName) }
    }

    fun changeSurname(newSurname: String) = intent {
        val state = state as? RegisterState.Success ?: return@intent
        reduce { state.copy(surname = newSurname) }
    }

    fun changePhone(newPhone: String) = intent {
        val state = state as? RegisterState.Success ?: return@intent
        reduce { state.copy(phone = newPhone) }
    }

    fun changeEmail(newEmail: String) = intent {
        val state = state as? RegisterState.Success ?: return@intent
        reduce { state.copy(email = newEmail) }
    }

    fun changePassword(newPassword: String) = intent {
        val state = state as? RegisterState.Success ?: return@intent
        reduce { state.copy(password = newPassword) }
    }

    fun changeConfirmPassword(newConfirmPassword: String) = intent {
        val state = state as? RegisterState.Success ?: return@intent
        reduce { state.copy(confirmPassword = newConfirmPassword) }
    }

    fun switchPasswordVisibility(newValue: Boolean) = intent {
        val state = state as? RegisterState.Success ?: return@intent
        reduce { state.copy(showPassword = newValue) }
    }


    fun register() = intent {
        val state = state as? RegisterState.Success ?: return@intent

        if (!isValidFields(state)) {
            return@intent
        }

        userRepository.signUpUser(
            LoginModel(
                firstName = state.name,
                lastName = state.surname,
                phone = state.phone,
                email = state.email,
                password = state.password,
                passwordAgain = state.confirmPassword
            )
        ).collect { result ->

            result.onSuccess {
                postSideEffect(RegisterEffect.NavigateToHome)
            }

            result.onFailure { throwable ->
                val message = throwable.mapToRegisterMessage()
                postSideEffect(RegisterEffect.ShowSnackBar(message, false))
            }
        }
    }

    private fun Throwable.mapToRegisterMessage(): String {
        return when (this) {
            is RegisterExceptions.EmailAlreadyException -> resourcesProvider.getString(R.string.email_already_registered)
            is RegisterExceptions.PhoneAlreadyException -> resourcesProvider.getString(R.string.phone_already_registered)
            is RegisterExceptions.SimplePasswordException -> resourcesProvider.getString(R.string.password_too_simple)
            else -> resourcesProvider.getString(R.string.unknown_error)
        }
    }


    private suspend fun Syntax<RegisterState, RegisterEffect>.isValidFields(state: RegisterState.Success): Boolean {
        if (state.password.length < 8) {
            postSideEffect(
                RegisterEffect.ShowSnackBar(
                    resourcesProvider.getString(R.string.password_incorrect),
                    false
                )
            )
            return false
        } else if (state.password != state.confirmPassword) {
            postSideEffect(
                RegisterEffect.ShowSnackBar(
                    resourcesProvider.getString(R.string.confirm_password_incorrect),
                    false
                )
            )
            return false
        } else if (
            state.name.isBlank() || state.email.isBlank()
            || state.surname.isBlank() || state.name.isBlank()
            || state.phone.isBlank() || state.confirmPassword.isBlank()
            || state.password.isBlank()
        ) {
            postSideEffect(
                RegisterEffect.ShowSnackBar(
                    resourcesProvider.getString(R.string.blank_fields),
                    false
                )
            )
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            postSideEffect(
                RegisterEffect.ShowSnackBar(
                    resourcesProvider.getString(R.string.email_incorrect),
                    false
                )
            )
            return false
        } else if (isPhoneNumberValid(state.phone)) {
            postSideEffect(
                RegisterEffect.ShowSnackBar(
                    resourcesProvider.getString(R.string.phone_incorrect),
                    false
                )
            )
            return false
        }
        return true
    }






}