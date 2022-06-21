package io.github.aaron.github.api

import io.github.aaron.github.BuildConfig
import io.github.aaron.github.model.AccessToken
import io.github.aaron.github.model.RepoResult
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface LoginService {

    @GET("https://github.com/login/oauth/access_token")
    @Headers("Accept: application/json")
    fun authorizationsCode(@Query("client_id") client_id: String,
                           @Query("client_secret") client_secret: String,
                           @Query("code") code: String): Deferred<AccessToken>

}