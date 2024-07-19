package com.bedirhan.neows.feature.listnews.domain.usecase

import com.bedirhan.neows.feature.listnews.domain.ListNewsRepository
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsResponseUiModelList
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(
    private val newsRepository: ListNewsRepository
) {
    suspend operator fun invoke(searchDetail: String): NewsResponseUiModelList? {
        return newsRepository.searchNewsByContent(searchDetail)
    }
}