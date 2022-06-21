package io.github.aaron.github

import android.app.Application
import com.tencent.mmkv.MMKV
import io.github.aaron.github.di.appComponent
import org.koin.android.ext.android.startKoin

/**
 * application
 */
open class GithubApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        configureDi()
    }

    // config di
    open fun configureDi() =
        startKoin(this, provideComponent())

    // public api component
    open fun provideComponent() = appComponent
}