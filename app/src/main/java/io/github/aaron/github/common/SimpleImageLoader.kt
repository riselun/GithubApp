package io.github.aaron.github.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 *  一个简单的图片封装类，外层直接在这里使用，方便迁移底层图片库
 **/

object SimpleImageLoader {

    fun loadImageCircle(url: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }

    fun loadImage(url: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }

    fun loadImage(drawableRes: Int, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(drawableRes)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }
}