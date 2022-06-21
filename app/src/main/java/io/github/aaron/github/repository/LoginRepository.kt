package io.github.aaron.github.repository

import androidx.lifecycle.MutableLiveData
import io.github.aaron.github.BuildConfig
import io.github.aaron.github.api.LoginService
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.base.BaseViewModel
import io.github.aaron.github.di.storageModule
import io.github.aaron.github.model.Repo
import io.github.aaron.github.storage.SharedPrefsManager
import io.github.aaron.github.ui.login.LoginViewModel
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * oauth登陆
 **/

class LoginRepository (private val loginService: LoginService, private val prefsManager : SharedPrefsManager){

    private var supervisorJob = SupervisorJob()

    val networkState = MutableLiveData<NetworkState>()

    private var accessToken: String ?= null

    /**
     * 是否已经登陆
     */
    fun isLogin(): Boolean{
        return !prefsManager.getToken().isNullOrEmpty()
    }

    /**
     * 退出登陆
     */
    fun logout(){
        clearToken()
    }

    /**
     * 清除accesstoken
     */
    private fun clearToken(){
        prefsManager.saveToken("")
    }

    /**
     * 获取并保存accesstoken
     */
    fun auth(code: String, scope: CoroutineScope) {
        networkState.postValue(NetworkState.RUNNING)
        scope.launch(getJobErrorHandler() + supervisorJob) {
            val result = loginService.authorizationsCode(BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, code).await()
            accessToken = result.access_token
            if(accessToken.isNullOrEmpty()) {
                networkState.postValue(NetworkState.FAILED)
            } else {
                prefsManager.saveToken(accessToken)
                networkState.postValue(NetworkState.SUCCESS)
            }
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        Timber.e(this::class.java.simpleName, "An error happened: $e")
        networkState.postValue(NetworkState.FAILED)
    }
}