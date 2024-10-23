package com.example.banquemisrchallenge05.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    @Query("select * from nowPlaying_movies")
    fun getNowPlayingFromLocal(): Flow<List<NowPlayingMovie>>
    @Query("select * from popular_movies")
    fun getPopularFromLocal(): Flow<List<PopularMovie>>
    @Query("select * from upcoming_movies")
    fun getUpcomingFromLocal(): Flow<List<UpcomingMovie>>
    @Query("select * from movie_details where id=:id")
    fun getMovieDetailsFromLocal(id:Long): Flow<MovieDetails>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovie>)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPopularMovies(popularMovies: List<PopularMovie>)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovie>)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovieDetails(movieDetails: MovieDetails)
    @Query("delete from nowPlaying_movies")
    suspend fun deleteNowPlayingMovies()
    @Query("delete from popular_movies")
    suspend fun deletePopularMovies()
    @Query("delete from upcoming_movies")
    suspend fun deleteUpcomingMovies()
}