package com.example.banquemisrchallenge05.view.DetailsScreen


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.model.NetworkObserver
import com.example.banquemisrchallenge05.view.ui.uistate.MovieDetailsUiState
import com.example.banquemisrchallenge05.viewmodel.moviedetailsVM.MovieDetailsViewModel

@Composable
fun DetailsScreen(
    networkObserver: NetworkObserver,
    navController: NavHostController,
    movieDetailsViewModel: MovieDetailsViewModel,
    key: String, id: Long?
) {
    val isConnected by networkObserver.isConnected.collectAsState()
    val movieDetails by movieDetailsViewModel.movieDetails.collectAsState()
    val movieDetailsFromLocal by movieDetailsViewModel.movieDetailsFromLocal.collectAsState()
    if (isConnected) {
        LaunchedEffect(Unit) {
            Log.d("tag", "$id")
            if (id != null) {
                movieDetailsViewModel.getMovieDetails(key, id)
            }
        }
        when (movieDetails) {
            is MovieDetailsUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            is MovieDetailsUiState.Success -> {
                Log.d("tag", "success")
                val movie_details = (movieDetails as MovieDetailsUiState.Success).movieDetails
                if (movie_details != null) {
                    MovieDetails(navController, movie_details)
                }
            }

            is MovieDetailsUiState.Failure -> {
                val fail = (movieDetails as MovieDetailsUiState.Failure).t
                Log.d("tag", "fail ${fail.message} ")
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Failed to load movie details",
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    } else {
        LaunchedEffect(Unit) {
            if (id != null) {
                movieDetailsViewModel.getMovieDetailsFromLocal(id)
            }
        }
        when (movieDetailsFromLocal) {
            is MovieDetailsUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            is MovieDetailsUiState.Success -> {
                Log.d("tag", "success")
                val movie_details =
                    (movieDetailsFromLocal as MovieDetailsUiState.Success).movieDetails
                if (movie_details != null) {
                    MovieDetails(navController, movie_details)
                } else {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "No Data Found",
                            color = Color.Red,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            is MovieDetailsUiState.Failure -> {
                val fail = (movieDetails as MovieDetailsUiState.Failure).t
                Log.d("tag", "fail ${fail.message} ")
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Failed to load movie details",
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

    }
}