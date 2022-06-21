package io.github.aaron.github.ui.search.views

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import io.github.aaron.github.common.SimpleImageLoader
import io.github.aaron.github.model.Repo
import kotlinx.android.synthetic.main.item_search.view.*


class SearchViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    fun bindTo(repo: Repo?) {
        repo?.let {
            it.owner?.avatarUrl?.let { it1 -> SimpleImageLoader.loadImageCircle(it1, itemView.item_search_user_image_profile) }
            itemView.item_des_view.text = it.description
            itemView.item_repositories_score.text = it.stargazersCount?.toString() ?: "0"
            itemView.item_search_title.text = it.fullName
        }
    }


}