package com.example.movieinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieinfo.repository.NewsRepository
import com.example.movieinfo.navigation.AppNavigationGraph
import com.example.movieinfo.ui.theme.MovieInfoTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var newsRepository: NewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieInfoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppEntryPoint(newsRepository)
                }
            }
        }
    }
}

@Composable
fun AppEntryPoint(newsRepository: NewsRepository){
    AppNavigationGraph(newsRepository)
}