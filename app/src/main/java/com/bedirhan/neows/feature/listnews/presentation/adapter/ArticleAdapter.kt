package com.bedirhan.neows.feature.listnews.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bedirhan.neows.databinding.ItemNewsBinding
import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleUiModel

class ArticleAdapter : ListAdapter<ArticleUiModel, NewsViewHolder>(NewsDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}