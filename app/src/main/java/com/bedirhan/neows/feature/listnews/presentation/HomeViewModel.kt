package com.bedirhan.neows.feature.listnews.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedirhan.neows.feature.listnews.domain.uimodel.NewsUiModel
import com.bedirhan.neows.feature.listnews.domain.usecase.GetNewsByCategoryUseCase
import com.bedirhan.neows.feature.listnews.domain.usecase.GetTrendingNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsByCategoryUseCase: GetNewsByCategoryUseCase
) : ViewModel() {
    private val _articlesLiveData = MutableLiveData<List<NewsUiModel>?>()
    val articlesLiveData: MutableLiveData<List<NewsUiModel>?>
        get() = _articlesLiveData

    fun getNewsByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val articles = getNewsByCategoryUseCase(category)
                if (articles != null) {
                    _articlesLiveData.postValue(articles.articles)
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}