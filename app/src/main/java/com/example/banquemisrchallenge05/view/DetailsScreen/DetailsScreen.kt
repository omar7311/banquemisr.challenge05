package com.example.banquemisrchallenge05.view.DetailsScreen


import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.view.ListScreen.TopBar
import com.example.banquemisrchallenge05.view.ui.navigation.Screens
import com.example.banquemisrchallenge05.view.ui.uistate.MovieDetailsUiState
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MovieDetailsViewModel

@Composable
fun DetailsScreen(navController:NavHostController,movieDetailsViewModel: MovieDetailsViewModel,
                  key:String,id:Long?){
    LaunchedEffect(Unit) {
        Log.d("tag","$id")
        if (id != null) {
            movieDetailsViewModel.getMovieDetails(key,id)
        }
    }
    val movieDetails by movieDetailsViewModel.movieDetails.collectAsState()
    when (movieDetails) {
        is MovieDetailsUiState.Loading -> {}
        is MovieDetailsUiState.Success -> {
            Log.d("tag","success")
         val movie_details=(movieDetails as MovieDetailsUiState.Success).movieDetails
            MovieDetails(navController,movie_details)
        }

        is MovieDetailsUiState.Failure -> {
            val fail=(movieDetails as MovieDetailsUiState.Failure).t

            Log.d("tag","fail ${fail.message} ")

        }
    }
}