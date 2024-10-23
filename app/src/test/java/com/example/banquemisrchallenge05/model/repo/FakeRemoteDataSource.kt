package com.example.banquemisrchallenge05.model.repo

import com.example.banquemisrchallenge05.model.remote.IRemoteDataSource
import com.example.banquemisrchallenge05.model.remote.Movie
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRemoteDataSource(
    private val movies:MutableList<Movie>,
    private val movieDetails:MutableList<MovieDetails>
):IRemoteDataSource {
    override fun getNowPlayingMovies(key: String): Flow<List<Movie>> {
        return flow {
            emit(movies)
        }
    }

    override fun getPopularMovies(key: String): Flow<List<Movie>> {
        return flow {
            emit(movies)
        }
    }

    override fun getUpcomingMovies(key: String): Flow<List<Movie>> {
        return flow {
            emit(movies)
        }
    }

    override fun getMovieDetails(key: String, id: Long): Flow<MovieDetails> {
        return flow {
            for(i in movieDetails){
                if(i.id==id) emit(i)
            }
        }
    }
}