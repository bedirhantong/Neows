package com.bedirhan.neows.feature.listnews.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleUiModel

class NewsDiffCallBack() : DiffUtil.ItemCallback<ArticleUiModel>() {
    override fun areItemsTheSame(oldItem: ArticleUiModel, newItem: ArticleUiModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticleUiModel, newItem: ArticleUiModel): Boolean {
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