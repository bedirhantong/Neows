package com.bedirhan.neows.common

import android.widget.ImageView
import com.bedirhan.neows.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String?) {
    val options = RequestOptions()
        .placeholder(R.drawable.placeholder_centered)
        .error(R.drawable.placeholder_centered)

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun ImageView.loadCircularImage(url: String?) {
    val options = RequestOptions()
        .placeholder(R.drawable.placeholder_centered)
        .error(R.drawable.placeholder_centered)
        .transform(CircleCrop())

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun ImageView.loadRoundedCornerImage(url: String?, radius: Int) {
    val options = RequestOptions()
        .placeholder(R.drawable.placeholder_centered)
        .error(R.drawable.placeholder_centered)
        .transform(RoundedCorners(radius))

    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}



