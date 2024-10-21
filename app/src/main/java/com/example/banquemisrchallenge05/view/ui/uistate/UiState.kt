package com.example.banquemisrchallenge05.view.ui.uistate

import com.example.banquemisrchallenge05.model.remote.Movie

sealed class UiState {
    class Success(val movies:List<Movie>): UiState()
    class Failure(val t: Throwable): UiState()
    object Loading: UiState()
}