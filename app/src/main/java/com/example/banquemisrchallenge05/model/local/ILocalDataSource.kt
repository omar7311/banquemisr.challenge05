package com.example.banquemisrchallenge05.model.local


import com.example.banquemisrchallenge05.model.remote.MovieDetails
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {
    fun getNowPlayingFromLocal(): Flow<List<NowPlayingMovie>>
    fun getPopularFromLocal(): Flow<List<PopularMovie>>
    fun getUpcomingFromLocal(): Flow<List<UpcomingMovie>>
    fun getMovieDetailsFromLocal(id:Long): Flow<MovieDetails>
    suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovie>)
    suspend fun insertPopularMovies(popularMovies: List<PopularMovie>)
    suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovie>)
    suspend fun insertMovieDetails(movieDetails: MovieDetails)
    suspend fun deleteNowPlayingMovies()
    suspend fun deletePopularMovies()
    suspend fun deleteUpcomingMovies()
}