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
    override suspend fun getNews(): ArticleResponseUiModel {
        val response = apiService.getNews().body()!!
        return newsMapper.toDomain(response)

    }
}