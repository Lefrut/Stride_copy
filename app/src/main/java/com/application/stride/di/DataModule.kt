package com.application.stride.di

import com.application.stride_api.di.serviceStrideModule
import org.koin.dsl.module

val dataModule = module {
    includes(serviceStrideModule)
}