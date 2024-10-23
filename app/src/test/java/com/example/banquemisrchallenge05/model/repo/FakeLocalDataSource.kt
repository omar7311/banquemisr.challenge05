package com.example.banquemisrchallenge05.model.repo

import com.example.banquemisrchallenge05.model.local.ILocalDataSource
import com.example.banquemisrchallenge05.model.local.NowPlayingMovie
import com.example.banquemisrchallenge05.model.local.PopularMovie
import com.example.banquemisrchallenge05.model.local.UpcomingMovie
import com.example.banquemisrchallenge05.model.remote.Movie
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLocalDataSource(
    private val movies:MutableList<Movie>,
    private val movieDetails:MutableList<MovieDetails>
):ILocalDataSource {
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

    override suspend fun insertMovieDetails(movieDetails: MovieDetails) {
        this.movieDetails.add(movieDetails)
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