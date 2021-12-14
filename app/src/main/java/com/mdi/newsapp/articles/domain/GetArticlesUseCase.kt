package com.mdi.newsapp.articles.domain

import com.mdi.newsapp.articles.data.Article
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val repository: IArticlesRepository) :
    UseCase<Unit, Pair<List<Article>?, Exception?>> {
    override suspend fun execute(input: Unit?): Pair<List<Article>?, Exception?> {
        return repository.getArticles()
    }
}