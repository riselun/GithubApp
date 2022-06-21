package io.github.aaron.github.di

import com.tencent.mmkv.MMKV
import io.github.aaron.github.storage.SharedPrefsManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val storageModule = module {
    single { SharedPrefsManager(androidContext()) }
    single { MMKV.defaultMMKV() }
}