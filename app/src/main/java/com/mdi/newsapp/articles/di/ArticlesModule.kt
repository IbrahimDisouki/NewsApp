package com.mdi.newsapp.articles.di

import com.mdi.newsapp.articles.data.ArticlesRemoteDataSource
import com.mdi.newsapp.articles.data.ArticlesRepository
import com.mdi.newsapp.articles.data.IArticlesRemoteDataSource
import com.mdi.newsapp.articles.domain.IArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticlesModule {
    @Binds
    abstract fun bindArticlesRemoteDataSource(articlesRemoteDataSource: ArticlesRemoteDataSource): IArticlesRemoteDataSource

    @Binds
    abstract fun bindArticlesRepository(articlesRepository: ArticlesRepository): IArticlesRepository
}