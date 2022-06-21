package io.github.aaron.github.storage

import android.content.Context
import android.content.SharedPreferences
import io.github.aaron.github.extensions.get
import io.github.aaron.github.extensions.setValue
import kotlin.reflect.KProperty

class SharedPrefsManager(private val context: Context) {

    private fun get(): SharedPreferences =
        context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)


    companion object {
        private const val SP_NAME = "GithubAppPreferences"
        private const val ACCESS_TOKEN_TAG = "accessToken_tag"
    }

   fun saveToken(token: String?){
       token?.let {
           get().setValue(ACCESS_TOKEN_TAG, it)
       }
   }

    fun getToken(): String? {
        return get().get(ACCESS_TOKEN_TAG, "")
    }
}