package com.example.banquemisrchallenge05.viewmodel.movieslistVM

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.banquemisrchallenge05.model.local.NowPlayingMovie
import com.example.banquemisrchallenge05.model.local.PopularMovie
import com.example.banquemisrchallenge05.model.local.UpcomingMovie
import com.example.banquemisrchallenge05.model.repo.movieDetailsListTest
import com.example.banquemisrchallenge05.model.repo.movieListTest
import com.example.banquemisrchallenge05.view.ui.uistate.ListScreenUiState
import com.example.banquemisrchallenge05.view.ui.uistate.MovieDetailsUiState
import com.example.banquemisrchallenge05.viewmodel.FakeRepository
import com.example.banquemisrchallenge05.viewmodel.moviedetailsVM.MovieDetailsViewModel
import com.example.banquemisrchallenge05.viewmodel.moviedetailsVM.MovieDetailsViewModelFactory
import kotlinx.coroutines.test.runTest
import org.checkerframework.checker.units.qual.m
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsEqual
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesListViewModelTest {
    lateinit var repo: FakeRepository
    lateinit var factory: MoviesListViewModelFactory
    lateinit var moviesListViewModel: MoviesListViewModel

    @Before
    fun setUp(){
        repo= FakeRepository(movieListTest, movieDetailsListTest)
        factory= MoviesListViewModelFactory(repo)
        moviesListViewModel= MoviesListViewModel(repo)
    }

    @Test
    fun getNowPlayingMovies() {
        moviesListViewModel.getNowPlayingMovies("key")
        val movies=moviesListViewModel.movies.value
        if(movies is ListScreenUiState.Success) {
            MatcherAssert.assertThat(movies.movies, IsEqual(movieListTest))
        }
    }

    @Test
    fun getPopularMovies() {
        moviesListViewModel.getPopularMovies("")
        val movies=moviesListViewModel.movies.value
        if(movies is ListScreenUiState.Success) {
            MatcherAssert.assertThat(movies.movies, IsEqual(movieListTest))
        }
    }

    @Test
    fun getUpcomingMovies() {
        moviesListViewModel.getUpcomingMovies("")
        val movies=moviesListViewModel.movies.value
        if(movies is ListScreenUiState.Success) {
            MatcherAssert.assertThat(movies.movies, IsEqual(movieListTest))
        }
    }

    @Test
    fun getNowPlayingFromLocal()= runTest {
        val nowPlayingMovies = movieListTest.map {
            NowPlayingMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        moviesListViewModel.getNowPlayingFromLocal()
        val movies=moviesListViewModel.moviesFromLocal.value
        if(movies is ListScreenUiState.Success) {
            MatcherAssert.assertThat(movies.movies, IsEqual(nowPlayingMovies))
        }
    }

    @Test
    fun getPopularFromLocal() {
        val popularMovies = movieListTest.map {
            PopularMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        moviesListViewModel.getPopularFromLocal()
        val movies=moviesListViewModel.moviesFromLocal.value
        if(movies is ListScreenUiState.Success) {
            MatcherAssert.assertThat(movies.movies, IsEqual(popularMovies))
        }
    }

    @Test
    fun getUpcomingFromLocal() {
        val upcomingMovies = movieListTest.map {
            UpcomingMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        moviesListViewModel.getUpcomingFromLocal()
        val movies=moviesListViewModel.moviesFromLocal.value
        if(movies is ListScreenUiState.Success) {
            MatcherAssert.assertThat(movies.movies, IsEqual(upcomingMovies))
        }
    }

    @Test
    fun insertNowPlayingMovies() {
        val nowPlayingMovies = mutableListOf(
            NowPlayingMovie(456,"tit","12-12","p_p")
        )
        moviesListViewModel.insertNowPlayingMovies(nowPlayingMovies)
        MatcherAssert.assertThat(nowPlayingMovies.first(), IsEqual(movieListTest.last()))

    }

    @Test
    fun insertPopularMovies() {
        val popularMovies = mutableListOf(
            PopularMovie(456,"tit","12-12","p_p")
        )
        moviesListViewModel.insertPopularMovies(popularMovies)
        MatcherAssert.assertThat(popularMovies.first(), IsEqual(movieListTest.last()))
    }

    @Test
    fun insertUpcomingMovies() {
        val upcomingMovies = mutableListOf(
            UpcomingMovie(456,"tit","12-12","p_p")
        )
        moviesListViewModel.insertUpcomingMovies(upcomingMovies)
        MatcherAssert.assertThat(upcomingMovies.first(), IsEqual(movieListTest.last()))
    }

    @Test
    fun deleteNowPlayingMovies() {
        moviesListViewModel.deleteNowPlayingMovies()
        MatcherAssert.assertThat(emptyList(),IsEqual(movieListTest))
    }

    @Test
    fun deletePopularMovies() {
        moviesListViewModel.deletePopularMovies()
        MatcherAssert.assertThat(emptyList(),IsEqual(movieListTest))
    }

    @Test
    fun deleteUpcomingMovies() {
        moviesListViewModel.deleteUpcomingMovies()
        MatcherAssert.assertThat(emptyList(),IsEqual(movieListTest))
    }
}