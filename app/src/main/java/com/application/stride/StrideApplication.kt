package com.application.stride

import android.app.Application
import com.application.common.resources.resourcesProviderModule
import com.application.stride.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class StrideApplication: Application()  {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StrideApplication)
            modules(appModule)
        }

    }

}