package com.bedirhan.neows.feature.listnews.domain.uimodel

data class NewsResponseUiModelList(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<NewsUiModel>? = null
)