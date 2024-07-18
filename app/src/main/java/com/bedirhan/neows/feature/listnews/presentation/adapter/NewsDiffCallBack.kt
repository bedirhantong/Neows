package com.bedirhan.neows.feature.listnews.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bedirhan.neows.feature.listnews.data.remote.model.Article

class NewsDiffCallBack() : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return when {
            oldItem.title != newItem.title -> {
                false
            }

            oldItem.url != newItem.url -> {
                false
            }

            oldItem.author != newItem.author -> {
                false
            }

            else -> true
        }
    }
}