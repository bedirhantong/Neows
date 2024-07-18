package com.bedirhan.neows.common.mapper.news

import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleDto
import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponseDto
import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleResponseUiModel
import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleUiModel

class NewsMapper {

    fun toDomain(response: ArticleDto, sourceMapper: SourceMapper): ArticleUiModel = ArticleUiModel(
        content = response.content,
        description = response.description,
        title = response.title,
        author = response.author,
        url = response.url,
        urlToImage = response.urlToImage,
        publishedAt = response.publishedAt,
        source = response.source?.let { sourceMapper.toDomain(it) },
    )


    fun fromDomain(articleDomainModel: ArticleUiModel, sourceMapper: SourceMapper)
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


    fun toDomainList(tList: List<ArticleDto>): List<ArticleUiModel> =
        tList.map { response ->
            toDomain(response = response, SourceMapper())
        }

    fun fromDomainList(domainList: List<ArticleUiModel>): List<ArticleDto> =
        domainList.map {
            fromDomain(it, SourceMapper())
        }

    fun toDomain(response: ArticleResponseDto): ArticleResponseUiModel = ArticleResponseUiModel(
        articles = toDomainList(response.articles),
        status = response.status,
        totalResults = response.totalResults
    )
}