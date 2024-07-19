package com.bedirhan.neows.common.mapper.news

import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleDto
import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponseDto
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsResponseUiModelList
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsUiModel

class NewsMapper {
    fun toDomain(response: ArticleDto, sourceMapper: SourceMapper): NewsUiModel = NewsUiModel(
        content = response.content,
        description = response.description,
        title = response.title,
        author = response.author,
        url = response.url,
        urlToImage = response.urlToImage,
        publishedAt = response.publishedAt,
        source = response.source?.let { sourceMapper.toDomain(it) },
    )

    fun fromDomain(articleDomainModel: NewsUiModel, sourceMapper: SourceMapper)
            : ArticleDto = ArticleDto(
        publishedAt = articleDomainModel.publishedAt,
        url = articleDomainModel.url,
        urlToImage = articleDomainModel.urlToImage,
        author = articleDomainModel.author,
        description = articleDomainModel.description,
        title = articleDomainModel.title,
        content = articleDomainModel.content,
        source = articleDomainModel.source?.let { sourceMapper.fromDomain(it) }
    )

    fun toDomainList(tList: List<ArticleDto>): List<NewsUiModel> =
        tList.map { response ->
            toDomain(response = response, SourceMapper())
        }

    fun fromDomainList(domainList: List<NewsUiModel>): List<ArticleDto> =
        domainList.map {
            fromDomain(it, SourceMapper())
        }

    fun toDomain(response: ArticleResponseDto): NewsResponseUiModelList? =
        response.articles?.let { toDomainList(it) }?.let {
            response.status?.let { it1 ->
                response.totalResults?.let { it2 ->
                    NewsResponseUiModelList(
                        articles = it,
                        status = it1,
                        totalResults = it2
                    )
                }
            }
        }
}