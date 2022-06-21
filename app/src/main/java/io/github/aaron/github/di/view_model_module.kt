package io.github.aaron.github.di

import io.github.aaron.github.ui.login.LoginViewModel
import io.github.aaron.github.ui.login.UserViewModel
import io.github.aaron.github.ui.search.SearchViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { UserViewModel(get()) }


}
