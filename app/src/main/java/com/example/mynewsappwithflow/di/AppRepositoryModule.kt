package com.mashhurbek.myinfoaplication.di

import com.mashhurbek.myinfoaplication.data.repository.AppRepository
import com.example.mynewsappwithflow.data.repository.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module

@InstallIn(SingletonComponent::class)
interface AppRepositoryModule {

    @Binds
    fun bindsAppRepository(impl: AppRepositoryImpl): AppRepository

}