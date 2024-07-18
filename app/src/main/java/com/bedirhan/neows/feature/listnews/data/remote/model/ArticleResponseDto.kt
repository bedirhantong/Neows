package com.bedirhan.neows.feature.listnews.data.remote.model

import com.google.gson.annotations.SerializedName

data class ArticleResponseDto(
    @SerializedName("articles")
    val articles: List<ArticleDto>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)
