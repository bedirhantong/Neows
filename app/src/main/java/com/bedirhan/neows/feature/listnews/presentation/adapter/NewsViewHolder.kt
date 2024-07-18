package com.bedirhan.neows.feature.listnews.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bedirhan.neows.R
import com.bedirhan.neows.databinding.ItemNewsBinding
import com.bedirhan.neows.feature.listnews.data.remote.model.Article
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class NewsViewHolder(
    private val binding: ItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {

    private fun customizedPlaceHolder (): CircularProgressDrawable {
        return  CircularProgressDrawable(binding.root.context).apply {
            strokeWidth = 8f
            centerRadius = 40f
            start()
        }
    }

    private val options = RequestOptions()
        .placeholder(customizedPlaceHolder()).fitCenter().error(R.mipmap.ic_launcher)
    fun bind(news: Article){
        binding.apply {
            textViewTitle.text = news.title
            textViewDescription.text = news.description
            textViewPublishedAt.text = news.publishedAt
            textViewAuthor.text = news.author
        }
        Glide.with(binding.imageViewArticle.context)
            .setDefaultRequestOptions(options)
            .load(news.urlToImage)
            .into(binding.imageViewArticle)
    }
}