package io.github.aaron.github.api

import io.github.aaron.github.BuildConfig
import io.github.aaron.github.model.RepoResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoService {

    @GET("search/repositories")
    fun search(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("sort") sort: String,
        @Query("order") order: String = "desc",//不需要传出去了
        @Query("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Query("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET
    ): Deferred<RepoResult>


}