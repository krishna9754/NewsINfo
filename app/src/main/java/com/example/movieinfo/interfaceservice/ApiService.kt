package com.example.movieinfo.interfaceservice

import com.example.movieinfo.data.GameItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("v2/top-headlines")
    suspend fun getGames(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "eb3ecd354a0c4f9da3106fcbf60e0adb"
    ): Response<GameItem>
}


//https://newsapi.org/v2/top-headlines?country=us&apiKey=eb3ecd354a0c4f9da3106fcbf60e0adb