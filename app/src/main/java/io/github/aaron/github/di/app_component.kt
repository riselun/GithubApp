package io.github.aaron.github.di

import io.github.aaron.github.di.networkModule
import io.github.aaron.github.di.repositoryModule
import io.github.aaron.github.di.storageModule
import io.github.aaron.github.di.viewModelModule

val appComponent = listOf(networkModule, viewModelModule, repositoryModule, storageModule)