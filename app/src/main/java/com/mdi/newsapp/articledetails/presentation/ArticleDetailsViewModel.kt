package com.mdi.newsapp.articledetails.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mdi.newsapp.articles.data.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(), ContainerHost<ArticleDetailsState, Nothing> {

    override val container = container<ArticleDetailsState, Nothing>(ArticleDetailsState(), savedStateHandle) {  }

    fun setArticleDetails(article: Article) = intent(registerIdling = false) {
        reduce {
            state.copy(article = article)
        }
    }

}