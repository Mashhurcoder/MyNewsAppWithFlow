package com.example.mynewsappwithflow.presentation.screen.screenNew

import com.example.mynewsappwithflow.data.remote.model.param.NewsParam
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface NewsViewModel {
    val newsList: StateFlow<List<NewsParam>>
    fun loadList()
    fun searchViews(query: String)
}