package com.application.stride.di

import com.application.home.HomeViewModel
import com.application.login.LoginViewModel
import com.application.register.RegisterViewModel
import com.application.start.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::StartViewModel)

    viewModelOf(::LoginViewModel)

    viewModelOf(::RegisterViewModel)

    viewModelOf(::HomeViewModel)

}