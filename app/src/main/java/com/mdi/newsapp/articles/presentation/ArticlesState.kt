package com.mdi.newsapp.articles.presentation

import android.os.Parcelable
import com.mdi.newsapp.articles.data.Article
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ArticlesState(val articles: @RawValue List<Article>? = null, val error: Exception? = null) : Parcelable