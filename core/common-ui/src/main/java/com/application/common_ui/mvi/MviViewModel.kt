package com.application.common_ui.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.Syntax


open class MviViewModel<State : Any, SideEffect : Any>(
    initialState: State,
    onCreate: (suspend Syntax<State, SideEffect>.() -> Unit)? = null
) : ViewModel(), ContainerHost<State, SideEffect> {

    override val container: Container<State, SideEffect> =
        viewModelScope.container(initialState = initialState, onCreate = onCreate)


}