package com.example.banquemisrchallenge05.view.ui.uistate

import com.example.banquemisrchallenge05.model.remote.Movie

sealed class ListScreenUiState {
    class Success(val movies:List<Movie>): ListScreenUiState()
    class Failure(val t: Throwable): ListScreenUiState()
    object Loading: ListScreenUiState()
}