package com.mdi.newsapp.articles.presentation

import com.mdi.newsapp.articles.data.Article

sealed class ArticlesSideEffect {
    data class NavigateToArticleDetails(val article: Article) : ArticlesSideEffect()
}