package io.github.aaron.github.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.github.aaron.github.model.Repo
import io.github.aaron.github.repository.RepoRepository
import kotlinx.coroutines.CoroutineScope

class RepoSourceFactory(
    private val repository: RepoRepository,
    private var query: String = "",
    private var sort: String = "stars",
    private val scope: CoroutineScope
) : DataSource.Factory<Int, Repo>() {

    val source = MutableLiveData<RepoDataSource>()

    override fun create(): DataSource<Int, Repo> {
        val source = RepoDataSource(repository, query, sort, scope)
        this.source.postValue(source)
        return source
    }

    fun getQuery() = query

    fun getSource() = source.value

    fun updateQuery(query: String) {
        this.query = query
        getSource()?.refresh()
    }
}