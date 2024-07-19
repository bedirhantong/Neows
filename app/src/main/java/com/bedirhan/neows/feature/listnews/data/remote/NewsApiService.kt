package com.bedirhan.neows.feature.listnews.data.remote

import com.bedirhan.neows.BuildConfig
import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET(TOP_HEADLINES_END_POINT)
    suspend fun getPopularNewsByEndpoint(
        @Query("country")
        country:String = NEWS_COUNTRY_CODE,
        @Query("apiKey")
        apiKey: String = NEWS_API_KEY,
        @Query("pageSize")
        pageSize:Int = 10,
        @Query("page")
        page:Int = 1
    ): Response<ArticleResponseDto>

    @GET(TOP_HEADLINES_END_POINT)
    suspend fun getNewsByCategoryEndpoint(
        @Query("country")
        country:String = NEWS_COUNTRY_CODE,
        @Query("category")
        category: String,
        @Query("apiKey")
        apiKey: String = NEWS_API_KEY,
        @Query("pageSize")
        pageSize:Int = 15,
        @Query("page")
        page:Int = 1
    ):Response<ArticleResponseDto>

    @GET(EVERYTHING_END_POINT)
    suspend fun searchByContentEndpoint(
        @Query("q")
        q:String,
        @Query("apiKey")
        apiKey: String = NEWS_API_KEY,
    ): Response<ArticleResponseDto>

    companion object {
        const val NEWS_API_KEY = BuildConfig.API_KEY
        const val NEWS_COUNTRY_CODE = "us"
        const val TOP_HEADLINES_END_POINT = "v2/top-headlines"
        const val EVERYTHING_END_POINT = "v2/everything"
    }
}