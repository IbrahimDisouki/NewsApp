package com.mdi.newsapp.articles.data

interface IArticlesRemoteDataSource {
    suspend fun getArticles(): ApiResponse
}