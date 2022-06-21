package io.github.aaron.github.api

import io.github.aaron.github.model.User
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.*


interface UserService {

    @GET("user")
    fun getPersonInfo(
            @Header("forceNetWork") forceNetWork: Boolean
    ): Deferred<User>

    @GET("users/{user}")
    fun getUser(
            @Header("forceNetWork") forceNetWork: Boolean,
            @Path("user") user: String
    ): Deferred<User>



}
