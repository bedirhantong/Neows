package com.bedirhan.neows.feature.listnews.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsUiModel

class NewsDiffCallBack: DiffUtil.ItemCallback<NewsUiModel>() {
    override fun areItemsTheSame(oldItem: NewsUiModel, newItem: NewsUiModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsUiModel, newItem: NewsUiModel): Boolean {
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