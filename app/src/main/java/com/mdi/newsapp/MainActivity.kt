package com.mdi.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mdi.newsapp.articledetails.presentation.ArticleDetailsViewModel
import com.mdi.newsapp.articledetails.presentation.ui.ArticleDetailsScreen
import com.mdi.newsapp.articles.presentation.ArticlesViewModel
import com.mdi.newsapp.articles.presentation.ui.ArticlesListScreen
import com.mdi.newsapp.common.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "articles") {
                composable("articles") {
                    val viewModel = hiltViewModel<ArticlesViewModel>()
                    NewsAppTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(color = MaterialTheme.colors.background) {
                            ArticlesListScreen(navController = navController, viewModel = viewModel)
                        }
                    }
                }

                composable("detail") {
                    val parentEntry = remember {
                        navController.getBackStackEntry("articles")
                    }
                    val viewModel = hiltViewModel<ArticleDetailsViewModel>(parentEntry)
                    NewsAppTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(color = MaterialTheme.colors.background) {
                            ArticleDetailsScreen(
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                    }
                }
            }
        }
    }
}