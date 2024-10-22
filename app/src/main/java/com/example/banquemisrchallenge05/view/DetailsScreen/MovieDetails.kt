package com.example.banquemisrchallenge05.view.DetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import com.example.banquemisrchallenge05.view.ListScreen.TopBar
import com.example.banquemisrchallenge05.view.ui.navigation.Screens

@Composable
fun MovieDetails(navController: NavHostController,movieDetails: MovieDetails){
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(Screens.MovieDetails.title)
        PosterImage(movieDetails.poster_path,movieDetails.backdrop_path)
        MovieInfo(movieDetails.original_title,movieDetails.release_date,
            movieDetails.runtime,movieDetails.genres)
        MovieOverview(movieDetails.overview)
    }
}