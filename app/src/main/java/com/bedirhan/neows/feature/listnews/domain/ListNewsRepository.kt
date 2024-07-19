package com.bedirhan.neows.feature.listnews.domain

import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsResponseUiModelList

interface ListNewsRepository {
    suspend fun getPopularNews(): NewsResponseUiModelList?

    suspend fun getNewsByCategory(choosenCategory: String): NewsResponseUiModelList?

    suspend fun searchNewsByContent(searchDetail: String): NewsResponseUiModelList?
}