package com.bedirhan.neows.feature.listnews.domain

import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleResponseUiModel

interface ListNewsRepository {
    suspend fun getNews(): ArticleResponseUiModel
}