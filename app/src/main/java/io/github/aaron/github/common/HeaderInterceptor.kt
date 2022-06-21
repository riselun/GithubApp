package io.github.aaron.github.common

import io.github.aaron.github.storage.SharedPrefsManager
import okhttp3.Interceptor
import timber.log.Timber

/**
 * 拦截header，注入登录token
 **/

class HeaderInterceptor(private val sharedPrefsManager: SharedPrefsManager){

    private fun getAuthorization(): String {
        return "token ${sharedPrefsManager.getToken()}"

    }

    /**
     * 拦截头部增加token
     */
    fun get(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()

            if (!sharedPrefsManager.getToken().isNullOrEmpty()) {
                //add access token
                val accessToken = getAuthorization()
                Timber.d("headerInterceptor", accessToken)
                val url = request.url().toString()
                request = request.newBuilder()
                    .addHeader("Authorization", accessToken)
                    .url(url)
                    .build()
            }

            chain.proceed(request)
        }

    }
}