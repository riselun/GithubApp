package io.github.aaron.github.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.model.Repo
import io.github.aaron.github.repository.RepoRepository
import kotlinx.coroutines.*
import timber.log.Timber

/**
 *  仓库数据源
 **/

class RepoDataSource (private val repository: RepoRepository,  private val query: String,
                      private val sort: String,     private val scope: CoroutineScope
) : PageKeyedDataSource<Int, Repo>(){

    // data
    private var supervisorJob = SupervisorJob()
    private val networkState = MutableLiveData<NetworkState>()
    private var retryQuery: (() -> Any)? =
        null // Keep reference

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Repo>
    ) {
        retryQuery = { loadInitial(params, callback) }
        executeQuery(1, params.requestedLoadSize) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Repo>) {
        //no used
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Repo>) {
        val page = params.key
        retryQuery = { loadAfter(params, callback) }
        executeQuery(page, params.requestedLoadSize) {
            callback.onResult(it, page + 1)
        }
    }

    private fun executeQuery(page: Int, perPage: Int, callback: (List<Repo>) -> Unit) {
        networkState.postValue(NetworkState.RUNNING)
        scope.launch(getJobErrorHandler() + supervisorJob) {
            delay(200) // To handle user typing case
            val result = repository.searchRepoWithPagination(query, page, perPage, sort)
            retryQuery = null
            networkState.postValue(NetworkState.SUCCESS)
            callback(result)
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        Timber.e(this::class.java.simpleName, "An error happened: $e")
        networkState.postValue(NetworkState.FAILED)
    }

    override fun invalidate() {
        super.invalidate()
        supervisorJob.cancelChildren()   // Cancel possible running job to only keep last result searched by user
    }

    /**
     * 网络状态
     */
    fun getNetworkState(): LiveData<NetworkState> =
        networkState

    /**
     * 刷新数据
     */
    fun refresh() = this.invalidate()

    /**
     * 重试数据
     */
    fun retryFailedQuery() {
        val prevQuery = retryQuery
        retryQuery = null
        prevQuery?.invoke()
    }
}