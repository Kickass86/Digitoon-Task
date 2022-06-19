package com.fapna.tasktobedone

import androidx.lifecycle.ViewModel
import com.fapna.tasktobedone.model.SearchResponse
import com.fapna.tasktobedone.network.ApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainViewModel(): ViewModel() {

    private val repository: Repository by lazy {
        Repository()
    }

    suspend fun fetchFilms(): Flow<SearchResponse?> = flow {
        try {
            val response = repository.getSearchResult(API_KEY, SEARCH_TERM)
            emit(response)
        } catch (e: Exception) {
            emit(null)
        }
    }



    companion object {
        const val API_KEY = "3e974fca"
        const val SEARCH_TERM = "batman"
    }
}