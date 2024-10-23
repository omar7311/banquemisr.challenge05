package com.example.banquemisrchallenge05.viewmodel.moviedetailsVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import com.example.banquemisrchallenge05.model.repo.IRepository
import com.example.banquemisrchallenge05.view.ui.uistate.MovieDetailsUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val repo:IRepository):ViewModel() {
    private val _movieDetails= MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Loading)
    val movieDetails: StateFlow<MovieDetailsUiState> = _movieDetails
    private val _movieDetailsFromLocal= MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Loading)
    val movieDetailsFromLocal: StateFlow<MovieDetailsUiState> = _movieDetailsFromLocal
    fun getMovieDetails(key:String,id:Long){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getMovieDetails(key, id)
                .catch {
                _movieDetails.emit(MovieDetailsUiState.Failure(it))
                }
                .collect{
                    _movieDetails.emit(MovieDetailsUiState.Success(it))
                    insertMovieDetails(it)
                }

        }
    }
    fun getMovieDetailsFromLocal(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getMovieDetailsFromLocal(id)
                .catch {
                    _movieDetailsFromLocal.emit(MovieDetailsUiState.Failure(it))
                }
                .collect{
                    _movieDetailsFromLocal.emit(MovieDetailsUiState.Success(it))
                }
        }
    }
    fun insertMovieDetails(movieDetails: MovieDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertMovieDetails(movieDetails)
        }
    }
}