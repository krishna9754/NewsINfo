package com.example.movieinfo.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfo.data.GameItem
import com.example.movieinfo.repository.NewsRepository
import com.example.movieinfo.state.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<GameItem>> = MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<GameItem>> = _news

    init {
        getNews("us")
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewHeadLine(country).collectLatest { newsResponse ->
                _news.value = newsResponse
            }
        }
    }
}