package com.example.mynewsappwithflow.data.remote.service

import com.example.mynewsappwithflow.data.remote.model.response.InfoResponse
import com.example.mynewsappwithflow.data.remote.model.response.QueryItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/top-news")
    suspend fun getTopNews(
        @Query("api-key") apiKey: String = "718214d7e2184473977d1951d79256f9",
        @Query("source-country") country: String = "us",
        @Query("language") language: String = "en"
    ): InfoResponse

    @GET("/search-news")
    suspend fun getWords(
        @Query("api-key") apiKey: String = "718214d7e2184473977d1951d79256f9",
        @Query("text") text: String,
        @Query("source-country") country: String = "us",
        @Query("language") language: String = "en"
    ): QueryItemResponse
}