package com.mdi.newsapp.articledetails.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mdi.newsapp.R
import com.mdi.newsapp.articledetails.presentation.ArticleDetailsViewModel
import com.mdi.newsapp.articles.data.Article
import com.mdi.newsapp.common.ui.AppBar
import com.mdi.newsapp.common.ui.ArticleImage

@Composable
fun ArticleDetailsScreen(navController: NavController, viewModel: ArticleDetailsViewModel) {

    val state = viewModel.container.stateFlow.collectAsState().value

    Column {
        AppBar(topAppBarText = state.article?.title ?: stringResource(id = R.string.app_name)) {
            navController.popBackStack()
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            state.article?.urlToImage?.let { urlToImage ->
                ArticleImage(urlToImage = urlToImage)
            }

            state.article?.title?.let { title ->
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                )
            }

            state.article?.content?.let { content ->
                Text(
                    text = content,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                )
            }

        }
    }

}