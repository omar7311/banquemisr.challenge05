package com.example.banquemisrchallenge05.viewmodel.moviedetailsVM

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import com.example.banquemisrchallenge05.model.remote.genre
import com.example.banquemisrchallenge05.model.repo.movieDetailsListTest
import com.example.banquemisrchallenge05.model.repo.movieListTest
import com.example.banquemisrchallenge05.view.ui.uistate.MovieDetailsUiState
import com.example.banquemisrchallenge05.viewmodel.FakeRepository
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModel
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModelFactory
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsEqual
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDetailsViewModelTest {
    lateinit var repo:FakeRepository
    lateinit var factory: MovieDetailsViewModelFactory
    lateinit var moviesDetailsViewModel: MovieDetailsViewModel

    @Before
    fun setUp(){
        repo=FakeRepository(movieListTest, movieDetailsListTest)
         factory=MovieDetailsViewModelFactory(repo)
        moviesDetailsViewModel= MovieDetailsViewModel(repo)
    }

    @Test
    fun getMovieDetails() {
        moviesDetailsViewModel.getMovieDetails("",123)
        val movieDetails=moviesDetailsViewModel.movieDetails.value
        if(movieDetails is MovieDetailsUiState.Success) {
            MatcherAssert.assertThat(movieDetails, IsEqual(movieDetailsListTest[0]))
        }
    }

    @Test
    fun getMovieDetailsFromLocal() {
        moviesDetailsViewModel.getMovieDetailsFromLocal(123)
        val movieDetails=moviesDetailsViewModel.movieDetailsFromLocal.value
        if(movieDetails is MovieDetailsUiState.Success) {
            MatcherAssert.assertThat(movieDetails, IsEqual(movieDetailsListTest[0]))
        }
    }

    @Test
    fun insertMovieDetails()= runTest {
        val genres= listOf(genre(11,"drama"))
        val movieDetails= MovieDetails(123456,"titl","12-2024","backdrop path"
            ,"poster path 1","overview 1",1002, genres)
       moviesDetailsViewModel.insertMovieDetails(movieDetails)
        MatcherAssert.assertThat(movieDetails, IsEqual(movieDetailsListTest.last()))
    }
}