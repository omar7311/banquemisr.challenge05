package com.example.banquemisrchallenge05.model.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") key:String):ListMoviesResponse
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") key:String):ListMoviesResponse
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") key:String):ListMoviesResponse
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") id: Long,@Query("api_key") key: String):MovieDetails
}