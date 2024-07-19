package com.bedirhan.neows.feature.listnews.domain

import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleResponseUiModel

interface ListNewsRepository {
    suspend fun getPopularNews(): ArticleResponseUiModel

    suspend fun getNewsByCategory(choosenCategory : String): ArticleResponseUiModel

    suspend fun searchNewsByContent(searchDetail : String) : ArticleResponseUiModel

}