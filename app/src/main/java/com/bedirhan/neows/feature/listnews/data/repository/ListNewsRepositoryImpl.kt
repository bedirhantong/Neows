package com.bedirhan.neows.feature.listnews.data.repository

import com.bedirhan.neows.feature.listnews.data.remote.NewsApiService
import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponse
import com.bedirhan.neows.feature.listnews.domain.ListNewsRepository
import javax.inject.Inject

class ListNewsRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService
) : ListNewsRepository {
    override suspend fun getNews(): ArticleResponse {
        return apiService.getNews().body()!!
    }
}