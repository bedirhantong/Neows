package com.bedirhan.neows.common.mapper.news

import com.bedirhan.neows.feature.listnews.data.remote.model.SourceDto
import com.bedirhan.neows.feature.listnews.domain.uimodel.SourceUiModel

class SourceMapper {
    fun toDomain(response: SourceDto): SourceUiModel = SourceUiModel(
        name = response.name,
        id = response.id
    )

    fun fromDomain(domainModel: SourceUiModel): SourceDto = SourceDto(
        name = domainModel.name,
        id = domainModel.id
    )
}