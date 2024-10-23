package com.example.banquemisrchallenge05.model.repo

import com.example.banquemisrchallenge05.model.local.NowPlayingMovie
import com.example.banquemisrchallenge05.model.local.PopularMovie
import com.example.banquemisrchallenge05.model.local.UpcomingMovie
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import com.example.banquemisrchallenge05.model.remote.genre
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryImpleTest {
    lateinit var remote:FakeRemoteDataSource
    lateinit var local:FakeLocalDataSource
    lateinit var repo:RepositoryImple
    @Before
    fun setup(){
        //given
        local= FakeLocalDataSource(movieListTest, movieDetailsListTest)
        remote= FakeRemoteDataSource(movieListTest, movieDetailsListTest)
        repo= RepositoryImple(remote,local)
    }
    @Test
    fun getNowPlayingMovies()= runTest {
        repo.getNowPlayingMovies("").collectLatest {
            MatcherAssert.assertThat(it,IsEqual(movieListTest))
        }

    }

    @Test
    fun getPopularMovies() = runTest{
        repo.getPopularMovies("").collectLatest {
            MatcherAssert.assertThat(it,IsEqual(movieListTest))
        }

    }

    @Test
    fun getUpcomingMovies()= runTest {
        repo.getUpcomingMovies("").collectLatest {
            MatcherAssert.assertThat(it,IsEqual(movieListTest))
        }
    }

    @Test
    fun getMovieDetails()= runTest {
        repo.getMovieDetails("",123).collectLatest {
            MatcherAssert.assertThat(it,IsEqual(movieDetailsListTest[0]))
        }
    }

    @Test
    fun getNowPlayingFromLocal()= runTest {
        val nowPlayingMovies = movieListTest.map {
            NowPlayingMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        repo.getNowPlayingFromLocal().collectLatest {
            MatcherAssert.assertThat(it,IsEqual(nowPlayingMovies))
        }
    }

    @Test
    fun getPopularFromLocal()= runTest {
        val popularMovies = movieListTest.map {
            PopularMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        repo.getPopularFromLocal().collectLatest {
            MatcherAssert.assertThat(it,IsEqual(popularMovies))
        }
    }

    @Test
    fun getUpcomingFromLocal()= runTest {
        val upcomingMovies = movieListTest.map {
            UpcomingMovie(it.id, it.title, it.release_date, it.poster_path)
        }
        repo.getUpcomingFromLocal().collectLatest {
            MatcherAssert.assertThat(it,IsEqual(upcomingMovies))
        }
    }

    @Test
    fun getMovieDetailsFromLocal()= runTest {
        repo.getMovieDetailsFromLocal(123).collectLatest {
            MatcherAssert.assertThat(it,IsEqual(movieDetailsListTest[0]))
        }
    }

    @Test
    fun insertNowPlayingMovies()= runTest {
        val nowPlayingMovies = mutableListOf(
            NowPlayingMovie(456,"tit","12-12","p_p")
        )
        repo.insertNowPlayingMovies(nowPlayingMovies)
        MatcherAssert.assertThat(nowPlayingMovies.first(),IsEqual(movieListTest.last()))
    }

    @Test
    fun insertPopularMovies()= runTest {
        val popularMovies = mutableListOf(
            PopularMovie(456,"tit","12-12","p_p")
        )
        repo.insertPopularMovies(popularMovies)
        MatcherAssert.assertThat(popularMovies.first(),IsEqual(movieListTest.last()))
    }

    @Test
    fun insertUpcomingMovies()= runTest {
        val upcomingMovies = mutableListOf(
            UpcomingMovie(456,"tit","12-12","p_p")
        )
        repo.insertUpcomingMovies(upcomingMovies)
        MatcherAssert.assertThat(upcomingMovies.first(),IsEqual(movieListTest.last()))
    }

    @Test
    fun insertMovieDetails()= runTest {
        val genres= listOf(genre(11,"drama"))
        val movieDetails= MovieDetails(123456,"titl","12-2024","backdrop path"
            ,"poster path 1","overview 1",1002, genres)
        repo.insertMovieDetails(movieDetails)
        MatcherAssert.assertThat(movieDetails,IsEqual(movieDetailsListTest.last()))
    }

    @Test
    fun deleteNowPlayingMovies()= runTest {
        repo.deleteNowPlayingMovies()
        MatcherAssert.assertThat(emptyList(),IsEqual(movieListTest))
    }

    @Test
    fun deletePopularMovies()= runTest {
        repo.deletePopularMovies()
        MatcherAssert.assertThat(emptyList(),IsEqual(movieListTest))
    }

    @Test
    fun deleteUpcomingMovies() = runTest{
        repo.deleteUpcomingMovies()
        MatcherAssert.assertThat(emptyList(),IsEqual(movieListTest))
    }
}