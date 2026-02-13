package com.example.mynewsappwithflow.presentation.screen.screenNew

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsappwithflow.data.remote.model.param.NewsParam
import com.mashhurbek.myinfoaplication.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NewsViewModelImpl @Inject constructor(private val repository: AppRepository): ViewModel(),
    NewsViewModel {

    private var query = ""
    override val newsList = MutableStateFlow<List<NewsParam>>(emptyList())

    override fun loadList() {
        viewModelScope.launch {
            if (query.isEmpty()){
                repository.getNews().collect { result->
                    if(result.isSuccess){
                        newsList.value = result.topNews
                    }
                }
            }else{
                repository.getTextByQuery(query).collectLatest { result->
                    if(result.isSuccess){
                        newsList.value = result.topNews
                    }
                }
            }
        }
    }

    override fun searchViews(query: String) {
        this.query = query
        loadList()
    }
}