package io.github.aaron.github.repository

import io.github.aaron.github.api.RepoService
import io.github.aaron.github.model.Repo
import io.github.aaron.github.model.RepoResult

class RepoRepository(private val service: RepoService) {

    suspend fun searchRepoWithPagination(
        query: String, page: Int,
        perPage: Int,
        sort: String
    ): List<Repo> {
        val list = service.search(query, page, perPage, sort).await()
        val result = mutableListOf<Repo>()
        result.addAll(list.items)
        return result

    }

}