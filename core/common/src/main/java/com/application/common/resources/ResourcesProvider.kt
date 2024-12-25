package com.application.common.resources

import android.content.res.Resources
import androidx.annotation.StringRes
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


val resourcesProviderModule = module {

    factory { androidContext().resources }

    singleOf(::ResourcesProviderImpl) bind ResourcesProvider::class

}

interface ResourcesProvider {

    fun getString(@StringRes id: Int): String

}

internal class ResourcesProviderImpl(
    private val resources: Resources
) : ResourcesProvider {
    override fun getString(id: Int): String {
        return resources.getString(id)
    }
}