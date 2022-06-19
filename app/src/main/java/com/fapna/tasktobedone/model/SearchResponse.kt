package com.fapna.tasktobedone.model

data class SearchResponse(
    val Search : List<Film>,
    val totalResults : Int,
    val Response : Boolean
)