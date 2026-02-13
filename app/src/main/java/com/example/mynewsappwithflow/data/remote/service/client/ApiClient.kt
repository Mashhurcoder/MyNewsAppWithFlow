package com.example.mynewsappwithflow.data.remote.service.client

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)

object ApiClient {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.worldnewsapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}