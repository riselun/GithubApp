package io.github.aaron.github.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.base.BaseViewModel
import io.github.aaron.github.datasource.RepoSourceFactory
import io.github.aaron.github.repository.LoginRepository
import io.github.aaron.github.repository.RepoRepository

class LoginViewModel(private  val repository: LoginRepository) : BaseViewModel() {


    val networkState = repository.networkState

    fun oauth(code: String) {
        repository.auth(code, ioScope)
    }

    /**
     * 是否已经登陆
     */
    fun isLogin(): Boolean{
        return repository.isLogin()
    }

    fun getProfile(){

    }
}