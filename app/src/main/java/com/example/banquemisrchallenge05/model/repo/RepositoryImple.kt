package com.example.banquemisrchallenge05.model.repo

import com.example.banquemisrchallenge05.model.local.ILocalDataSource
import com.example.banquemisrchallenge05.model.local.NowPlayingMovie
import com.example.banquemisrchallenge05.model.local.PopularMovie
import com.example.banquemisrchallenge05.model.local.UpcomingMovie
import com.example.banquemisrchallenge05.model.remote.IRemoteDataSource
import com.example.banquemisrchallenge05.model.remote.Movie
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import kotlinx.coroutines.flow.Flow

class RepositoryImple(private val remote: IRemoteDataSource, private val local: ILocalDataSource) :
    IRepository {
    override fun getNowPlayingMovies(key: String): Flow<List<Movie>> {
        return remote.getNowPlayingMovies(key)
    }

    override fun getPopularMovies(key: String): Flow<List<Movie>> {
        return remote.getPopularMovies(key)
    }

    override fun getUpcomingMovies(key: String): Flow<List<Movie>> {
        return remote.getUpcomingMovies(key)
    }

    override fun getMovieDetails(key: String, id: Long): Flow<MovieDetails> {
        return remote.getMovieDetails(key, id)
    }

    override fun getNowPlayingFromLocal(): Flow<List<NowPlayingMovie>> {
        return local.getNowPlayingFromLocal()
    }

    override fun getPopularFromLocal(): Flow<List<PopularMovie>> {
        return local.getPopularFromLocal()
    }

    override fun getUpcomingFromLocal(): Flow<List<UpcomingMovie>> {
        return local.getUpcomingFromLocal()
    }

    override fun getMovieDetailsFromLocal(id: Long): Flow<MovieDetails> {
        return local.getMovieDetailsFromLocal(id)
    }

    override suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovie>) {
        local.insertNowPlayingMovies(nowPlayingMovies)
    }

    override suspend fun insertPopularMovies(popularMovies: List<PopularMovie>) {
        local.insertPopularMovies(popularMovies)
    }

    override suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovie>) {
        local.insertUpcomingMovies(upcomingMovies)
    }

    override suspend fun insertMovieDetails(movieDetails: MovieDetails) {
        local.insertMovieDetails(movieDetails)
    }

    override suspend fun deleteNowPlayingMovies() {
        local.deleteNowPlayingMovies()
    }

    override suspend fun deletePopularMovies() {
        local.deletePopularMovies()
    }

    override suspend fun deleteUpcomingMovies() {
        local.deleteUpcomingMovies()
    }
}