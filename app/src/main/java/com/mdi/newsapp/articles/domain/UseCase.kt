package com.mdi.newsapp.articles.domain

interface UseCase<Input, Output> {
    suspend fun execute(input: Input? = null): Output
}