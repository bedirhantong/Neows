package com.bedirhan.neows.feature.listnews.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedirhan.neows.feature.listnews.data.remote.model.ArticleDto
import com.bedirhan.neows.feature.listnews.domain.uimodel.ArticleUiModel
import com.bedirhan.neows.feature.listnews.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _articlesLiveData = MutableLiveData<List<ArticleUiModel>>()
    val articlesLiveData: LiveData<List<ArticleUiModel>>
        get() = _articlesLiveData

    fun getTopHeadlines() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val articles = getNewsUseCase()
                _articlesLiveData.postValue(articles.articles)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}