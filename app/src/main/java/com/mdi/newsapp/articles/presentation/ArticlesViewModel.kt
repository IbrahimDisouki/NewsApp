package com.mdi.newsapp.articles.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mdi.newsapp.articles.data.Article
import com.mdi.newsapp.articles.domain.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel(), ContainerHost<ArticlesState, ArticlesSideEffect> {
    override val container =
        container<ArticlesState, ArticlesSideEffect>(ArticlesState(), savedStateHandle) {
            getArticles()
        }

    private fun getArticles(): Unit = intent(registerIdling = false) {
        val articles = getArticlesUseCase.execute()
        reduce {
            state.copy(articles = articles.first, error = articles.second)
        }
    }

    fun articleDetails(article: Article) = intent {
        postSideEffect(ArticlesSideEffect.NavigateToArticleDetails(article))
    }

}