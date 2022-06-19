package com.fapna.tasktobedone

import com.fapna.tasktobedone.model.SearchResponse
import com.fapna.tasktobedone.network.ApiClient
class Repository() {

    private val apiClient: ApiClient by lazy {
        ApiClient()
    }

    suspend fun getSearchResult(apiKey:String, searchTerm: String): SearchResponse =
        fetchFilms(apiKey, searchTerm)


    private suspend fun fetchFilms(apiKey: String, searchTerm:String): SearchResponse =
        apiClient.apiService.getSearchResult(apiKey, searchTerm)

}

