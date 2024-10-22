package com.example.banquemisrchallenge05.viewmodel.movieslistVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.banquemisrchallenge05.model.repo.IRepository
import com.example.banquemisrchallenge05.view.ui.uistate.ListScreenUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MoviesListViewModel(private val repo:IRepository):ViewModel() {
     private val _movies= MutableStateFlow<ListScreenUiState>(ListScreenUiState.Loading)
     val movies:StateFlow<ListScreenUiState> = _movies

     fun getNowPlayingMovies(key:String) {
          viewModelScope.launch(Dispatchers.IO) {
               repo.getNowPlayingMovies(key)
                    .catch {
                         _movies.emit(ListScreenUiState.Failure(it))
                    }
                    .collect {
                      _movies.emit(ListScreenUiState.Success(it))
                    }
          }
     }

     fun getPopularMovies(key:String) {
          viewModelScope.launch(Dispatchers.IO) {
               repo.getPopularMovies(key)
                    .catch {
                         _movies.emit(ListScreenUiState.Failure(it))
                    }
                    .collect {
                         _movies.emit(ListScreenUiState.Success(it))
                    }
          }
     }
     fun getUpcomingMovies(key:String) {
          viewModelScope.launch(Dispatchers.IO) {
               repo.getUpcomingMovies(key)
                    .catch {
                         _movies.emit(ListScreenUiState.Failure(it))
                    }
                    .collect {
                         _movies.emit(ListScreenUiState.Success(it))
                    }
          }
     }
}