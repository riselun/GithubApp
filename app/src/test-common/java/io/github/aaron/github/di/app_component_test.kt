package io.github.aaron.github.di

import io.github.aaron.github.di.repositoryModule
import io.github.aaron.github.di.viewModelModule
import io.github.aaron.github.di.configureNetworkModuleForTest


fun configureAppComponent(baseApi: String)
        = listOf(
    configureNetworkModuleForTest(baseApi),
    viewModelModule,
    repositoryModule
)