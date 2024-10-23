package com.example.banquemisrchallenge05.view.DetailsScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import com.example.banquemisrchallenge05.view.ListScreen.BottomNavBar
import com.example.banquemisrchallenge05.view.ListScreen.TopBar
import com.example.banquemisrchallenge05.view.ui.navigation.Screens

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieDetails(navController: NavHostController,movieDetails: MovieDetails){
    Scaffold(
        topBar = { TopBar(Screens.MovieDetails.title,navController) },
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).verticalScroll(
            rememberScrollState()
        )) {
            PosterImage(movieDetails.poster_path, movieDetails.backdrop_path)
            MovieInfo(
                movieDetails.original_title, movieDetails.release_date,
                movieDetails.runtime, movieDetails.genres
            )
            MovieOverview(movieDetails.overview)
        }
    }
}