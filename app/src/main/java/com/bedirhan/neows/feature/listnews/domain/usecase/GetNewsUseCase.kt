package com.bedirhan.neows.feature.listnews.domain.usecase

import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponse
import com.bedirhan.neows.feature.listnews.domain.ListNewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val newsRepository: ListNewsRepository
) {
    suspend operator fun invoke(): ArticleResponse {
        return newsRepository.getNews()
    }
}