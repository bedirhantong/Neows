package com.bedirhan.neows.feature.listnews.data.di

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
    fun provideNewsRepository(api: NewsApiService): ListNewsRepository = ListNewsRepositoryImpl(api)
}