package com.example.banquemisrchallenge05.model.remote

import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path
import retrofit2.http.Query


interface IRemoteDataSource {
     fun getNowPlayingMovies( key:String):Flow<List<Movie>>
     fun getPopularMovies( key:String):Flow<List<Movie>>
     fun getUpcomingMovies(key:String):Flow<List<Movie>>
     fun getMovieDetails( key:String,id:Long):Flow<MovieDetails>

}