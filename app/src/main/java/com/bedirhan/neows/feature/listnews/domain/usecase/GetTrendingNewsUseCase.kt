package com.bedirhan.neows.feature.listnews.domain.usecase

import com.bedirhan.neows.feature.listnews.domain.ListNewsRepository
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsResponseUiModelList
import javax.inject.Inject

class GetTrendingNewsUseCase @Inject constructor(
    private val newsRepository: ListNewsRepository
) {
    suspend operator fun invoke(): NewsResponseUiModelList? {
        return newsRepository.getPopularNews()
    }
}