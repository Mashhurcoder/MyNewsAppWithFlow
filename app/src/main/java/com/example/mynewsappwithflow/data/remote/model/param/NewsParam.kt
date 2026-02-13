package com.example.mynewsappwithflow.data.remote.model.param

import java.io.Serializable


data class NewsParam(
    val id: Int,
    val name: String,
    val desc: String,
    val date: String,
    val image: String,
    val author: String,
    val url: String
): Serializable