package com.example.banquemisrchallenge05.viewmodel.movieslistVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.banquemisrchallenge05.model.repo.IRepository
import com.example.banquemisrchallenge05.view.ui.uistate.MovieDetailsUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repo:IRepository):ViewModel() {
    private val _movieDetails= MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Loading)
    val movieDetails: StateFlow<MovieDetailsUiState> = _movieDetails

    fun getMovieDetails(key:String,id:Long){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getMovieDetails(key, id)
                .catch {
                _movieDetails.emit(MovieDetailsUiState.Failure(it))
            }
                .collect{
                    _movieDetails.emit(MovieDetailsUiState.Success(it))
                }

        }
    }
}