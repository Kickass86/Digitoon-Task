package com.fapna.tasktobedone.network

import com.fapna.tasktobedone.model.FilmDetailResponse
import com.fapna.tasktobedone.model.SearchResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class ApiClient {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }


    companion object {
        const val BASE_URL = ""
    }
}

interface ApiService{
    @GET("https://www.omdbapi.com/?apikey=3e974fca&s=batman")
    suspend fun getSearchResult(
        @Query("apikey") apiKey: String,
        @Query("s") searchKeyword: String
    ): SearchResponse

    @GET("https://www.omdbapi.com/?apikey=3e974fca&i={imdbID}")
    suspend fun getSegmentDiscovery(@Path("imdb_id") imdbID: String): FilmDetailResponse
}