package com.mdi.newsapp.articledetails.presentation

import android.os.Parcelable
import com.mdi.newsapp.articles.data.Article
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleDetailsState(val article: Article? = null) : Parcelable