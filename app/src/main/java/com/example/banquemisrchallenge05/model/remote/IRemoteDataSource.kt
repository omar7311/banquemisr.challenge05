package com.example.banquemisrchallenge05.model.remote

import kotlinx.coroutines.flow.Flow


interface IRemoteDataSource {
     fun getNowPlayingMovies( key:String):Flow<List<Movie>>
     fun getPopularMovies( key:String):Flow<List<Movie>>
     fun getUpcomingMovies(key:String):Flow<List<Movie>>
}