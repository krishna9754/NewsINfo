package com.example.movieinfo.datasource

import com.example.movieinfo.data.GameItem
import com.example.movieinfo.interfaceservice.ApiService
import retrofit2.Response
import javax.inject.Inject

class NewDataSourceImp @Inject constructor(private val apiService: ApiService): NewDataSource {
    override suspend fun getGames(country: String): Response<GameItem> {
        return apiService.getGames(country)
    }
}