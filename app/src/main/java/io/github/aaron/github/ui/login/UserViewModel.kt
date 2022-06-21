package io.github.aaron.github.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.base.BaseViewModel
import io.github.aaron.github.datasource.RepoSourceFactory
import io.github.aaron.github.model.User
import io.github.aaron.github.repository.LoginRepository
import io.github.aaron.github.repository.RepoRepository
import io.github.aaron.github.repository.UserRepository

class UserViewModel(private  val repository: UserRepository) : BaseViewModel() {

    val networkState = repository.networkState
    val user = MutableLiveData<User>()

    /**
     * 获取用户信息
     */
    fun getUser(name: String ?= null) {
        repository.getUser(name, ioScope, user)
    }

    /**
     * 是否已经登陆
     */
    fun isLogin(): Boolean{
        return repository.isLogin()
    }

    /**
     * 是否已经登陆
     */
    fun logout(){
        repository.logout()
    }

}