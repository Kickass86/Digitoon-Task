package com.fapna.tasktobedone.model

data class SearchResponse(
    val search : List<Film>,
    val totalResults : Int,
    val response : Boolean
)