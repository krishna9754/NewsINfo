package com.example.movieinfo.datasource

import com.example.movieinfo.data.GameItem
import retrofit2.Response

interface NewDataSource {
    suspend fun getGames(country: String): Response<GameItem>
}