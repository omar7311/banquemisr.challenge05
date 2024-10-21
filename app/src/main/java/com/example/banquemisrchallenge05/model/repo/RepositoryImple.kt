package com.example.banquemisrchallenge05.model.repo

import com.example.banquemisrchallenge05.model.local.ILocalDataSource
import com.example.banquemisrchallenge05.model.remote.IRemoteDataSource
import com.example.banquemisrchallenge05.model.remote.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
}