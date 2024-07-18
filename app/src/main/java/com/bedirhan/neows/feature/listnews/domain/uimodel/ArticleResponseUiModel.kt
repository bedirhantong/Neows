package com.bedirhan.neows.feature.listnews.domain.uimodel

data class ArticleResponseUiModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleUiModel>
)