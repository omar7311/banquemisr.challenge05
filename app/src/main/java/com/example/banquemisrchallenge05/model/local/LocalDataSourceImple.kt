package com.example.banquemisrchallenge05.model.local

import android.content.Context
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImple(private val context: Context):ILocalDataSource {
    val moviesDao=MoviesDatabase.getInstance(context).getMoviesDao()
    override fun getNowPlayingFromLocal(): Flow<List<NowPlayingMovie>> {
         return moviesDao.getNowPlayingFromLocal()
    }

    override fun getPopularFromLocal(): Flow<List<PopularMovie>> {
        return moviesDao.getPopularFromLocal()
    }

    override fun getUpcomingFromLocal(): Flow<List<UpcomingMovie>> {
        return moviesDao.getUpcomingFromLocal()
    }

    override fun getMovieDetailsFromLocal(id: Long): Flow<MovieDetails> {
        return moviesDao.getMovieDetailsFromLocal(id)
    }

    override suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovie>) {
        return moviesDao.insertNowPlayingMovies(nowPlayingMovies)
    }

    override suspend fun insertPopularMovies(popularMovies: List<PopularMovie>) {
        return moviesDao.insertPopularMovies(popularMovies)
    }

    override suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovie>) {
        return moviesDao.insertUpcomingMovies(upcomingMovies)
    }

    override suspend fun insertMovieDetails(movieDetails: MovieDetails) {
        return moviesDao.insertMovieDetails(movieDetails)
    }

    override suspend fun deleteNowPlayingMovies() {
        moviesDao.deleteNowPlayingMovies()
    }

    override suspend fun deletePopularMovies() {
        moviesDao.deletePopularMovies()
    }

    override suspend fun deleteUpcomingMovies() {
        moviesDao.deleteUpcomingMovies()
    }
}