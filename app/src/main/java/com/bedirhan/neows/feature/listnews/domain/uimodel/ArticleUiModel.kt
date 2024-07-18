package com.bedirhan.neows.feature.listnews.domain.uimodel

data class ArticleUiModel(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceUiModel?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)