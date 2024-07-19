package com.bedirhan.neows.feature.listnews.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bedirhan.neows.common.loadImage
import com.bedirhan.neows.databinding.ItemNewsBinding
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsUiModel
class NewsViewHolder(
    private val binding: ItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: NewsUiModel) {
        binding.apply {
            textViewTitle.text = news.title
            textViewDescription.text = news.description
            textViewPublishedAt.text = news.publishedAt
            textViewAuthor.text = news.author
            imageViewArticle.loadImage(news.urlToImage)
        }
    }
}