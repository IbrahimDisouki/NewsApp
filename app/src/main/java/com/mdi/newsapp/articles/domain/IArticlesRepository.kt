package com.mdi.newsapp.articles.domain

import com.mdi.newsapp.articles.data.Article

interface IArticlesRepository {
    suspend fun getArticles(): Pair<List<Article>?, Exception?>
}