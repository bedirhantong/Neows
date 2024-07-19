package com.bedirhan.neows.feature.listnews.domain.uimodel

data class NewsUiModel(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: SourceUiModel? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)