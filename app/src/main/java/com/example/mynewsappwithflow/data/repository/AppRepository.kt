package com.mashhurbek.myinfoaplication.data.repository

import com.example.mynewsappwithflow.data.remote.model.param.QueryItemsParam
import com.example.mynewsappwithflow.data.remote.model.param.TopNewsParam
import kotlinx.coroutines.flow.Flow


interface AppRepository {
    fun getNews (): Flow<TopNewsParam>
    fun getTextByQuery(text:String): Flow<QueryItemsParam>

}