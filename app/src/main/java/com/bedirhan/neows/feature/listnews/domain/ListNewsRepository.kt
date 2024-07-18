package com.bedirhan.neows.feature.listnews.domain

import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponse

interface ListNewsRepository {
    suspend fun getNews() : ArticleResponse
}