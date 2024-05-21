package com.example.movieinfo.repository

import com.example.movieinfo.data.GameItem
import com.example.movieinfo.datasource.NewDataSource
import com.example.movieinfo.state.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newDataSource: NewDataSource) {

    suspend fun getNewHeadLine(country: String) : Flow<ResourceState<GameItem>>{
        return flow {
            emit(ResourceState.Loading())

            val response = newDataSource.getGames(country)
            if (response.isSuccessful && response.body() != null){
                emit(ResourceState.Success(response.body()!!))
            }else{
                emit(ResourceState.Error("Error fetch news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e.localizedMessage ?: "Some Error in flow"))
        }
    }


}