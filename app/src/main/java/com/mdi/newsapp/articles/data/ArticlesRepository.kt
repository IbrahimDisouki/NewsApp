package com.mdi.newsapp.articles.data

import com.mdi.newsapp.articles.domain.IArticlesRepository
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val remoteDataSource: IArticlesRemoteDataSource
) : IArticlesRepository {
    override suspend fun getArticles(): Pair<List<Article>?, Exception?> {
        return try {
            Pair(remoteDataSource.getArticles().articles, null)
        } catch (e: Exception) {
            Pair(null, e)
        }
    }
}