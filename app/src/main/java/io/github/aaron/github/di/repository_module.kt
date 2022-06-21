package io.github.aaron.github.di

import io.github.aaron.github.repository.LoginRepository
import io.github.aaron.github.repository.RepoRepository
import io.github.aaron.github.repository.UserRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { RepoRepository(get()) }
    factory { LoginRepository(get(), get()) }
    factory { UserRepository(get(), get()) }

}