package com.bedirhan.neows.feature.listnews.data.remote

import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponseDto
import com.bedirhan.neows.utils.ApiConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET(ApiConstants.TOP_HEADLINES_END_POINT)
    suspend fun getPopularNewsByEndpoint(
        @Query("country")
        country:String = ApiConstants.NEWS_COUNTRY_CODE,
        @Query("apiKey")
        apiKey: String = ApiConstants.NEWS_API_KEY,
        @Query("pageSize")
        pageSize:Int = 10,
        @Query("page")
        page:Int = 1
    ): Response<ArticleResponseDto>


    @GET(ApiConstants.EVERYTHING_END_POINT)
    suspend fun getNewsByCategoryEndpoint(
        @Query("category")
        category: String,
        @Query("apiKey")
        apiKey: String = ApiConstants.NEWS_API_KEY,
    ):Response<ArticleResponseDto>


    @GET(ApiConstants.EVERYTHING_END_POINT)
    suspend fun searchByContentEndpoint(
        @Query("q")
        q:String,
        @Query("apiKey")
        apiKey: String = ApiConstants.NEWS_API_KEY,
    ): Response<ArticleResponseDto>
}