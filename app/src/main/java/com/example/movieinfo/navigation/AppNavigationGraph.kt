package com.example.movieinfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieinfo.repository.NewsRepository
import com.example.movieinfo.screens.HomeScreen
import com.example.movieinfo.viewmodel.MainViewModel

@Composable
fun AppNavigationGraph(newsRepository: NewsRepository){
    val mainViewModel = remember { MainViewModel(newsRepository) }
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN){
        composable(Routes.HOME_SCREEN){
            HomeScreen(mainViewModel)
        }
    }
}