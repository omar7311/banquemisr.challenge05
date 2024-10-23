package com.example.banquemisrchallenge05.view.DetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
    Card(modifier = Modifier.fillMaxWidth().height(250.dp).padding(8.dp)
        , shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(12.dp)){
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = backdropImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = posterImage, contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 120.dp, height = 180.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 12.dp)
            )
        }
    }

}