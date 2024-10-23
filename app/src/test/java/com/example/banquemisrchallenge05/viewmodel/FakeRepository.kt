package com.example.banquemisrchallenge05.viewmodel

import com.example.banquemisrchallenge05.model.local.NowPlayingMovie
import com.example.banquemisrchallenge05.model.local.PopularMovie
import com.example.banquemisrchallenge05.model.local.UpcomingMovie
import com.example.banquemisrchallenge05.model.remote.Movie
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import com.example.banquemisrchallenge05.model.repo.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository(
    private val movies:MutableList<Movie>,
    val movieDetails:MutableList<MovieDetails>
):IRepository {
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

    override fun getNowPlayingFromLocal(): Flow<List<NowPlayingMovie>> {
        val nowPlayingMovies = movies.map {
            NowPlayingMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        return flow {
            emit(nowPlayingMovies)
        }
    }

    override fun getPopularFromLocal(): Flow<List<PopularMovie>> {
        val popularMovies = movies.map {
            PopularMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        return flow {
            emit(popularMovies)
        }
    }

    override fun getUpcomingFromLocal(): Flow<List<UpcomingMovie>> {
        val upcomingMovies = movies.map {
            UpcomingMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        return flow {
            emit(upcomingMovies)
        }
    }

    override fun getMovieDetailsFromLocal(id: Long): Flow<MovieDetails> {
        return flow {
            for(i in movieDetails){
                if(i.id==id) emit(i)
            }
        }
    }

    override suspend fun insertNowPlayingMovies(nowPlayingMovies: List<NowPlayingMovie>) {
        movies.addAll(nowPlayingMovies)
    }

    override suspend fun insertPopularMovies(popularMovies: List<PopularMovie>) {
        movies.addAll(popularMovies)

    }

    override suspend fun insertUpcomingMovies(upcomingMovies: List<UpcomingMovie>) {
        movies.addAll(upcomingMovies)

    }

    override suspend fun insertMovieDetails(movieDetail: MovieDetails) {
        movieDetails.add(movieDetail)
    }

    override suspend fun deleteNowPlayingMovies() {
        movies.clear()
    }

    override suspend fun deletePopularMovies() {
        movies.clear()
    }

    override suspend fun deleteUpcomingMovies() {
        movies.clear()
    }

}