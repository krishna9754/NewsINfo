package com.example.movieinfo.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieinfo.state.ResourceState
import com.example.movieinfo.viewmodel.MainViewModel



@Composable
fun HomeScreen(
   mainViewModel: MainViewModel
){
    val newsResponse = mainViewModel.news.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {

        when(newsResponse.value){

            is ResourceState.Loading -> {
                LoadingScreen()
            }
            is ResourceState.Success -> {
                val response = (newsResponse.value as ResourceState.Success).data
                Log.d("HomeScreen", "inside ${response.totalResults}")
                Log.d("HomeScreen", "inside dsbfj")
                 NewsList(response )
            }
            is ResourceState.Error -> {

            }
        }
    }
}