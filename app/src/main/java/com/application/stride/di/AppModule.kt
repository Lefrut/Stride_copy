package com.application.stride.di

import com.application.common.resources.resourcesProviderModule
import org.koin.dsl.module

val appModule = module {

    includes(viewModelModule, dataModule, resourcesProviderModule)

}