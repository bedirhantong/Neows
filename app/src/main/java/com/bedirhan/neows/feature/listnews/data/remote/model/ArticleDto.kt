package com.bedirhan.neows.feature.listnews.data.remote.model

data class ArticleDto(
    /*
     - field name'i aynıysa SerializedName gerek yok
     */
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceDto?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)
