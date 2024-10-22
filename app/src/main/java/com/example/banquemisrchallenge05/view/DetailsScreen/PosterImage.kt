package com.example.banquemisrchallenge05.view.DetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun PosterImage(posterPath:String,backdropPath:String){
    val posterImage= rememberAsyncImagePainter(
        model = "https://image.tmdb.org/t/p/w500"+posterPath
    )
    val backdropImage= rememberAsyncImagePainter(
        model = "https://image.tmdb.org/t/p/w500"+backdropPath
    )
    Box(modifier = Modifier.fillMaxWidth().height(300.dp)){
        Image(painter =backdropImage ,contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())
        Image(painter =posterImage ,contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 150.dp, height = 250.dp).align(Alignment.CenterStart)
                .padding(start = 16.dp))

    }

}