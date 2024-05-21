package com.example.movieinfo.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.movieinfo.data.GameItem

@Composable
fun NewsList(response: GameItem) {
    LazyColumn {
        items(response.article){article ->
            Text(text = article.title ?: "NA")
            Text(text = "fdsdf")
//            Log.d("TEXT", "NewsList: ${allData.title}")
        }
    }
}