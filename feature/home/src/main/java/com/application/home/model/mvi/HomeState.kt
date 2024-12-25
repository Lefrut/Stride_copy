package com.application.home.model.mvi;

sealed class HomeState {

    data class Success(
        val username: String = "Robert Jones",
    ): HomeState()

}