package com.mdi.newsapp.articles.presentation.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdi.newsapp.articles.data.Article
import com.mdi.newsapp.common.ui.ArticleImage

@ExperimentalMaterialApi
@Composable
fun ArticleItem(
    darkTheme: Boolean = isSystemInDarkTheme(),
    article: Article,
    onClick: (article: Article) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = if (darkTheme) MaterialTheme.colors.primarySurface else Color.White,
        onClick = { onClick(article) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ArticleImage(urlToImage = article.urlToImage)
            Text(
                text = article.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = article.description,
                style = MaterialTheme.typography.caption,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            )
        }
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ArticleItemPreview() {
    ArticleItem(
        article = Article(
            "Hello World!",
            "Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!",
            "https://techcrunch.com/wp-content/uploads/2014/11/privacy.jpg?w=667",
            ""
        ), onClick = {}
    )
}