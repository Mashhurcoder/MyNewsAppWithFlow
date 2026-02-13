package com.example.mynewsappwithflow.data.remote.model.param

data class QueryItemsParam (
    val isSuccess: Boolean,
    val message : String,
    val topNews: List<NewsParam>
)