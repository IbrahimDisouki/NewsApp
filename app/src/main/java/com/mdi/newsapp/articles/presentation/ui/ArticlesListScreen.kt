package com.mdi.newsapp.articles.presentation.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mdi.newsapp.R
import com.mdi.newsapp.articledetails.presentation.ArticleDetailsViewModel
import com.mdi.newsapp.articles.presentation.ArticlesSideEffect
import com.mdi.newsapp.articles.presentation.ArticlesViewModel
import com.mdi.newsapp.common.ui.AppBar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ArticlesListScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavController,
    viewModel: ArticlesViewModel
) {

    val state = viewModel.container.stateFlow.collectAsState().value
    val parentEntry = remember {
        navController.getBackStackEntry("articles")
    }
    val articleDetailsViewModel = hiltViewModel<ArticleDetailsViewModel>(parentEntry)

    LaunchedEffect(viewModel) {
        launch {
            viewModel.container.sideEffectFlow.collect {
                handleSideEffect(
                    articleDetailsViewModel,
                    navController,
                    it
                )
            }
        }
    }

    Column {
        AppBar(topAppBarText = stringResource(id = R.string.app_name))

        state.articles?.let { articles ->
            LazyColumn {
                items(articles) { article ->
                    ArticleItem(darkTheme = darkTheme, article = article) {
                        viewModel.articleDetails(article)
                    }
                }
            }
        }
    }

}

fun handleSideEffect(
    viewModel: ArticleDetailsViewModel,
    navController: NavController,
    sideEffect: ArticlesSideEffect
) {
    when (sideEffect) {
        is ArticlesSideEffect.NavigateToArticleDetails -> {
            viewModel.setArticleDetails(sideEffect.article)
            navController.navigate("detail")
        }
    }
}