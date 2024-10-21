package com.example.banquemisrchallenge05.view.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.banquemisrchallenge05.model.local.LocalDataSourceImple
import com.example.banquemisrchallenge05.model.remote.RemoteDataSourceImple
import com.example.banquemisrchallenge05.model.repo.RepositoryImple
import com.example.banquemisrchallenge05.view.ListScreen.NowPlayingScreen
import com.example.banquemisrchallenge05.view.ListScreen.PopularScreen
import com.example.banquemisrchallenge05.view.ListScreen.UpcomingScreen
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModel
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModelFactory

@Composable
fun NavGraph(navController: NavHostController,key:String) {
    val repo=RepositoryImple(RemoteDataSourceImple(),LocalDataSourceImple())
    val movieListFactory=MoviesListViewModelFactory(repo)
    val moviesListViewModel:MoviesListViewModel= viewModel(factory = movieListFactory)
    NavHost(navController, Screens.NowPlaying.route) {
        composable(Screens.NowPlaying.route) { NowPlayingScreen(navController,moviesListViewModel,key) }
        composable(Screens.Popular.route) { PopularScreen(navController,moviesListViewModel,key) }
        composable(Screens.Upcoming.route) { UpcomingScreen(navController,moviesListViewModel,key) }
    }
}