package com.bedirhan.neows.feature.listnews.data.di

import com.bedirhan.neows.common.mapper.news.NewsMapper
import com.bedirhan.neows.feature.listnews.data.remote.NewsApiService
import com.bedirhan.neows.feature.listnews.data.repository.ListNewsRepositoryImpl
import com.bedirhan.neows.feature.listnews.domain.ListNewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ListNewsModule {

    @Provides
    @Singleton
    fun provideNewsMapper(): NewsMapper {
        return NewsMapper()
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        apiService: NewsApiService,
        newsMapper: NewsMapper
    ): ListNewsRepository {
        return ListNewsRepositoryImpl(apiService, newsMapper)
    }
}