package com.example.banquemisrchallenge05.model.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImple():IRemoteDataSource{
    private val apiServices=RetrofitClient.apiServices
    override fun getNowPlayingMovies(key: String): Flow<List<Movie>> {
      return flow {
          emit(apiServices.getNowPlayingMovies(key).results)
      }
    }

    override fun getPopularMovies(key: String): Flow<List<Movie>> {
        return flow {
            emit(apiServices.getPopularMovies(key).results)
        }
    }

    override fun getUpcomingMovies(key: String): Flow<List<Movie>> {
        return flow {
            emit(apiServices.getUpcomingMovies(key).results)
        }
    }

}