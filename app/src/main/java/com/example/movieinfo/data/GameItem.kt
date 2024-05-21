package com.example.movieinfo.data

import com.google.gson.annotations.SerializedName


data class GameItem(
     val article: List<Article>,
     val totalResults: Int,
)

data class Article (
    val status: String,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String?,
    val url: String,
    val urlToImage: String
)