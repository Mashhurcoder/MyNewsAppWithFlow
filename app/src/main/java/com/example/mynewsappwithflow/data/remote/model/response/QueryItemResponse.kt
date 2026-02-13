package com.example.mynewsappwithflow.data.remote.model.response

data class QueryItemResponse(
    val available: Int,
    val news: List<New>,
    val number: Int,
    val offset: Int
)