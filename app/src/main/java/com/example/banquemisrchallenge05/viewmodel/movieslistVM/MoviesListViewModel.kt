package com.example.banquemisrchallenge05.viewmodel.movieslistVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.banquemisrchallenge05.model.local.NowPlayingMovie
import com.example.banquemisrchallenge05.model.local.PopularMovie
import com.example.banquemisrchallenge05.model.local.UpcomingMovie
import com.example.banquemisrchallenge05.model.repo.IRepository
import com.example.banquemisrchallenge05.view.ui.uistate.ListScreenUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MoviesListViewModel(private val repo:IRepository):ViewModel() {
     private val _movies= MutableStateFlow<ListScreenUiState>(ListScreenUiState.Loading)
     val movies:StateFlow<ListScreenUiState> = _movies
     private val _moviesFromLocal= MutableStateFlow<ListScreenUiState>(ListScreenUiState.Loading)
     val moviesFromLocal:StateFlow<ListScreenUiState> = _moviesFromLocal
     fun getNowPlayingMovies(key:String) {
          viewModelScope.launch(Dispatchers.IO) {
               repo.getNowPlayingMovies(key)
                    .catch {
                         _movies.emit(ListScreenUiState.Failure(it))
                    }
                    .collect {
                      _movies.emit(ListScreenUiState.Success(it))
                         deleteNowPlayingMovies()
                         val nowPlayingMovies = it.map {
                              NowPlayingMovie(it.id, it.title, it.release_date, it.poster_path)
                         }
                         insertNowPlayingMovies(nowPlayingMovies)
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
                         deletePopularMovies()
                         val popularMovies = it.map {
                              PopularMovie(it.id, it.title, it.release_date, it.poster_path)
                         }
                         insertPopularMovies(popularMovies)
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
                         deleteUpcomingMovies()
                         val upcomingMovies = it.map {
                              UpcomingMovie(it.id, it.title, it.release_date, it.poster_path)
                         }
                         insertUpcomingMovies(upcomingMovies)
                    }
          }
     }
      fun getNowPlayingFromLocal()  {
           viewModelScope.launch {
                repo.getNowPlayingFromLocal()
                     .catch {
                          _moviesFromLocal.emit(ListScreenUiState.Failure(it))
                     }
                     .collect {
                          _moviesFromLocal.emit(ListScreenUiState.Success(it))
                     }
           }
     }

      fun getPopularFromLocal() {
           viewModelScope.launch {
                repo.getPopularFromLocal()
                     .catch {
                          _moviesFromLocal.emit(ListScreenUiState.Failure(it))
                     }
                     .collect {
                          _moviesFromLocal.emit(ListScreenUiState.Success(it))
                     }
           }
     }

     fun getUpcomingFromLocal() {
          viewModelScope.launch {
               repo.getUpcomingFromLocal()
                    .catch {
                         _moviesFromLocal.emit(ListScreenUiState.Failure(it))
                    }
                    .collect {
                         _moviesFromLocal.emit(ListScreenUiState.Success(it))
                    }
          }
     }



     fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovie>) {
          viewModelScope.launch {
               repo.insertNowPlayingMovies(nowPlayingMovies)
          }
     }

     fun insertPopularMovies(popularMovies: List<PopularMovie>) {
          viewModelScope.launch {
               repo.insertPopularMovies(popularMovies)
          }     }

      fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovie>) {
           viewModelScope.launch {
                repo.insertUpcomingMovies(upcomingMovies)
           }
     }



     fun deleteNowPlayingMovies() {
          viewModelScope.launch {
               repo.deleteNowPlayingMovies()
          }
     }

     fun deletePopularMovies() {
          viewModelScope.launch {
               repo.deletePopularMovies()
          }
     }

     fun deleteUpcomingMovies() {
          viewModelScope.launch {
               repo.deleteUpcomingMovies()
          }
     }
}