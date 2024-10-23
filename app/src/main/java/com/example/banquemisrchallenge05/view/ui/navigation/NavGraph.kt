package com.example.banquemisrchallenge05.view.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.banquemisrchallenge05.model.NetworkObserver
import com.example.banquemisrchallenge05.model.local.LocalDataSourceImple
import com.example.banquemisrchallenge05.model.remote.RemoteDataSourceImple
import com.example.banquemisrchallenge05.model.repo.RepositoryImple
import com.example.banquemisrchallenge05.view.DetailsScreen.DetailsScreen
import com.example.banquemisrchallenge05.view.ListScreen.NowPlayingScreen
import com.example.banquemisrchallenge05.view.ListScreen.PopularScreen
import com.example.banquemisrchallenge05.view.ListScreen.UpcomingScreen
import com.example.banquemisrchallenge05.viewmodel.moviedetailsVM.MovieDetailsViewModel
import com.example.banquemisrchallenge05.viewmodel.moviedetailsVM.MovieDetailsViewModelFactory
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModel
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModelFactory

@Composable
fun NavGraph(networkObserver: NetworkObserver,navController: NavHostController,key:String,context: Context) {
    val repo=RepositoryImple(RemoteDataSourceImple(),LocalDataSourceImple(context))
    val movieListFactory=MoviesListViewModelFactory(repo)
    val moviesListViewModel:MoviesListViewModel= viewModel(factory = movieListFactory)
    val movieDetailsFactory= MovieDetailsViewModelFactory(repo)
    val movieDetailsViewModel: MovieDetailsViewModel = viewModel(factory = movieDetailsFactory)
    NavHost(navController, Screens.NowPlaying.route) {
        composable(Screens.NowPlaying.route) { NowPlayingScreen(networkObserver,navController,moviesListViewModel,key) }
        composable(Screens.Popular.route) { PopularScreen(networkObserver,navController,moviesListViewModel,key) }
        composable(Screens.Upcoming.route) { UpcomingScreen(networkObserver,navController,moviesListViewModel,key) }
        composable(route="${Screens.MovieDetails.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType }))
        { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id")
              DetailsScreen(networkObserver,navController,movieDetailsViewModel,key,id)
        }
    }
}