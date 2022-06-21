package io.github.aaron.github.model

import com.google.gson.annotations.SerializedName

data class RepoResult(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("items") val items: List<Repo>
)