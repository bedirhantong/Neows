package com.bedirhan.neows.feature.listnews.data.remote.model

data class ArticleResponseDto(
    val articles: List<ArticleDto>?,
    val status: String?,
    val totalResults: Int?
)
