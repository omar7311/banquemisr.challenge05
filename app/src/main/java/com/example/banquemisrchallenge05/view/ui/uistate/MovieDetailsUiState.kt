package com.example.banquemisrchallenge05.view.ui.uistate

import com.example.banquemisrchallenge05.model.remote.Movie
import com.example.banquemisrchallenge05.model.remote.MovieDetails

sealed class MovieDetailsUiState {
    class Success(val movieDetails: MovieDetails): MovieDetailsUiState()
    class Failure(val t: Throwable): MovieDetailsUiState()
    object Loading: MovieDetailsUiState()
}