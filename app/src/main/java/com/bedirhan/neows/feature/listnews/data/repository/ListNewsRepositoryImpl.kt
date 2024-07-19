package com.bedirhan.neows.feature.listnews.data.repository

import com.bedirhan.neows.common.mapper.news.NewsMapper
import com.bedirhan.neows.feature.listnews.data.remote.NewsApiService
import com.bedirhan.neows.feature.listnews.domain.ListNewsRepository
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsResponseUiModelList
import javax.inject.Inject

class ListNewsRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService,
    private val newsMapper: NewsMapper
) : ListNewsRepository {
    override suspend fun getPopularNews(): NewsResponseUiModelList? {
        val response = apiService.getPopularNewsByEndpoint().body()
        return response?.let { newsMapper.toDomain(it) }
    }

    override suspend fun getNewsByCategory(choosenCategory : String): NewsResponseUiModelList? {
        val response = apiService.getNewsByCategoryEndpoint(category = choosenCategory).body()
        return response?.let { newsMapper.toDomain(it) }
    }

    override suspend fun searchNewsByContent(searchDetail: String): NewsResponseUiModelList? {
        val response = apiService.searchByContentEndpoint(searchDetail).body()
        return response?.let { newsMapper.toDomain(it) }
    }
}