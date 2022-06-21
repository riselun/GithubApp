package io.github.aaron.github.repository

import android.webkit.CookieManager
import android.webkit.WebStorage
import androidx.lifecycle.MutableLiveData
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.api.UserService
import io.github.aaron.github.model.User
import io.github.aaron.github.storage.SharedPrefsManager
import io.github.aaron.github.utils.NetUtil
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * 用户个人信息仓库
 **/

class UserRepository(
    private val userService: UserService,
    private val prefsManager: SharedPrefsManager
) {

    private var supervisorJob = SupervisorJob()
    val networkState = MutableLiveData<NetworkState>()

    /**
     * 是否已经登陆
     */
    fun isLogin(): Boolean {
        return !prefsManager.getToken().isNullOrEmpty()
    }

    /**
     * 退出登陆
     */
    fun logout() {
        clearToken()
        NetUtil.clearCookies()
    }

    /**
     * 清除accesstoken
     */
    private fun clearToken() {
        prefsManager.saveToken("")
    }



    /**
     * 获取并保存个人信息
     */
    fun getUser(userName: String?, scope: CoroutineScope, userLiveData: MutableLiveData<User>) {
        networkState.postValue(NetworkState.RUNNING)
        scope.launch(getJobErrorHandler() + supervisorJob) {
            val isLoginUser = userName == null
            //根据是否有用户名，获取第三方用户数据或者当前用户数据
            val user = if (isLoginUser) {
                userService.getPersonInfo(true).await()
            } else {
                userService.getUser(true, userName!!).await()
            }
            userLiveData.postValue(user)
            networkState.postValue(NetworkState.SUCCESS)
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        Timber.e(this::class.java.simpleName, "An error happened: $e")
        networkState.postValue(NetworkState.FAILED)
    }
}