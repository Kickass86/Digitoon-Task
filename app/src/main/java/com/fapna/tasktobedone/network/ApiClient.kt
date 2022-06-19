package com.fapna.tasktobedone.network

import com.fapna.tasktobedone.model.FilmDetailResponse
import com.fapna.tasktobedone.model.SearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class ApiClient {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getHttpClient())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level  = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(logging)
        return clientBuilder.build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }


    companion object {
        const val BASE_URL = "https://www.omdbapi.com/"
    }
}

interface ApiService{
    @GET(".")
    suspend fun getSearchResult(
        @Query("apikey") apiKey: String,
        @Query("s") searchKeyword: String
    ): SearchResponse

    @GET(".")
    suspend fun getSegmentDiscovery(
        @Query("imdb_id") imdbID: String
    ): FilmDetailResponse
}