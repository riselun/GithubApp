package io.github.aaron.github.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.github.aaron.github.api.NetworkState
import io.github.aaron.github.base.BaseViewModel
import io.github.aaron.github.datasource.RepoSourceFactory
import io.github.aaron.github.repository.RepoRepository

class SearchViewModel(
    repository: RepoRepository) : BaseViewModel() {

    private val dataSource = RepoSourceFactory(repository = repository, scope = ioScope)

    val repos = LivePagedListBuilder(dataSource, pagedListConfig()).build()
    val networkState: LiveData<NetworkState>? =
        switchMap(dataSource.source) { it.getNetworkState() }


    /**
     * 根据查询字搜索仓库（会去掉空格）
     */
    fun fetchRepoByName(query: String) {
        val search = query.trim()
        if (dataSource.getQuery() == search) return
        dataSource.updateQuery(search)
    }

    /**
     * 重试最后一个失败的请求
     */
    fun retryFailedRequest() =
        dataSource.getSource()?.retryFailedQuery()

    /**
     * 刷新数据
     */
    fun refreshAllList() =
        dataSource.getSource()?.refresh()

    /**
     * 返回现在的查询字
     */
    fun getCurrentQuery() =
        dataSource.getQuery()

    private fun pagedListConfig() = PagedList.Config.Builder()
        .setInitialLoadSizeHint(5)
        .setEnablePlaceholders(false)
        .setPageSize(5 * 2)
        .build()
}