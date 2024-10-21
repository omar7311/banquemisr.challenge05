package com.example.banquemisrchallenge05.model.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") key:String):ListMoviesResponse
    @GET("popular")
    suspend fun getPopularMovies(@Query("api_key") key:String):ListMoviesResponse
    @GET("upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") key:String):ListMoviesResponse
}