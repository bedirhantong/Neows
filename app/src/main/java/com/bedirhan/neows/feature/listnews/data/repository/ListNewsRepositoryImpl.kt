package com.bedirhan.neows.feature.listnews.data.repository

import com.bedirhan.neows.common.mapper.news.NewsMapper
import com.bedirhan.neows.feature.listnews.data.remote.NewsApiService
import com.bedirhan.neows.feature.listnews.domain.ListNewsRepository
import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleResponseUiModel
import javax.inject.Inject

class ListNewsRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService,
    private val newsMapper: NewsMapper
) : ListNewsRepository {
    override suspend fun getPopularNews(): ArticleResponseUiModel {
        val response = apiService.getPopularNewsByEndpoint().body()!!
        return newsMapper.toDomain(response)
    }

    override suspend fun getNewsByCategory(choosenCategory : String): ArticleResponseUiModel {
        val response = apiService.getNewsByCategoryEndpoint(choosenCategory).body()!!
        return newsMapper.toDomain(response)
    }

    override suspend fun searchNewsByContent(searchDetail: String): ArticleResponseUiModel {
        val response = apiService.searchByContentEndpoint(searchDetail).body()!!
        return newsMapper.toDomain(response)
    }
}