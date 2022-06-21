package io.github.aaron.github.model


import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * 用户数据
 */
class User {
    var login: String? = null
    var id: String? = null
    var name: String? = null
    var avatar_url: String? = null
    var html_url: String? = null
    var type: String? = null
    var company: String? = null
    var blog: String? = null
    var location: String? = null
    var email: String? = null
    var bio: String? = null
    var starRepos: Int? = null
    var honorRepos: Int? = null
    var public_repos: Int = 0
    var public_gists: Int = 0
    var followers: Int = 0
    var following: Int = 0
    var created_at: Date? = null
    var updated_at: Date? = null

}
