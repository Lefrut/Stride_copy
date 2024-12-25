package com.application.start

import com.application.common_ui.mvi.MviViewModel
import com.application.start.model.mvi.StartEffect
import com.application.start.model.mvi.StartState

class StartViewModel : MviViewModel<StartState, StartEffect>(StartState.Success){


    fun clickLogin() = intent {
        postSideEffect(StartEffect.NavigateToLogin)
    }

    fun clickRegister() = intent{
        postSideEffect(StartEffect.NavigateToRegister)
    }


}