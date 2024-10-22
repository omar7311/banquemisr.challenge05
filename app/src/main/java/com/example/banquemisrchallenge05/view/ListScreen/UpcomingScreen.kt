package com.example.banquemisrchallenge05.view.ListScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.view.ui.uistate.ListScreenUiState
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModel


@Composable
fun UpcomingScreen(navController: NavHostController, moviesListViewModel: MoviesListViewModel, key:String){
    LaunchedEffect(Unit) {
        moviesListViewModel.getUpcomingMovies(key)
    }
    val upcomingList by moviesListViewModel.movies.collectAsState()
    Scaffold(
        topBar = {},
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
            when(upcomingList){
                is ListScreenUiState.Loading->{ }
                is ListScreenUiState.Success->{
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        itemsIndexed((upcomingList as ListScreenUiState.Success).movies) { _, movie ->
                            MovieItem(movie, navController)
                        }
                    }
                }
                is ListScreenUiState.Failure->{ }
            }
        }

    }
}