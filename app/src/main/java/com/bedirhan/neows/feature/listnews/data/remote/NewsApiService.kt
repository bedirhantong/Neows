package com.bedirhan.neows.feature.listnews.data.remote

import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleResponse
import com.bedirhan.neows.utils.ApiConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET(ApiConstants.NEWS_END_POINT)
    suspend fun getNews(
        @Query("country")
        country: String = ApiConstants.NEWS_COUNTRY_CODE,
        @Query("apiKey")
        apiKey: String = ApiConstants.NEWS_API_KEY,
        ): Response<ArticleResponse>
}