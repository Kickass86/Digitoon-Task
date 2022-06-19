package com.fapna.tasktobedone

import com.fapna.tasktobedone.network.ApiClient

class MainViewModel(private val apiClient: ApiClient) {

    suspend fun fetchFilms() =
        apiClient.apiService.getSearchResult(API_KEY, SEARCH_TERM)


    companion object {
        const val API_KEY = "3e974fca"
        const val SEARCH_TERM = "batman"
    }
}