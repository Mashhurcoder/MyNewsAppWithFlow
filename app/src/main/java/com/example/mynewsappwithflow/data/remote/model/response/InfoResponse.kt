package com.example.mynewsappwithflow.data.remote.model.response

data class InfoResponse(
    val country: String,
    val language: String,
    val top_news: List<TopNew>
)