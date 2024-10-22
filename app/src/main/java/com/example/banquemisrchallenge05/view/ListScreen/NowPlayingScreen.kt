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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.view.ui.uistate.ListScreenUiState
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModel

@Composable
fun NowPlayingScreen(
    navController: NavHostController,
    moviesListViewModel: MoviesListViewModel,
    key: String
) {
    LaunchedEffect(Unit) {
        moviesListViewModel.getNowPlayingMovies(key)
    }
    val nowPlayingList by moviesListViewModel.movies.collectAsState()
    Scaffold(
        topBar = {  },
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            when (nowPlayingList) {
                is ListScreenUiState.Loading -> {}
                is ListScreenUiState.Success -> {
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize().padding(4.dp)
                    ) {
                        itemsIndexed((nowPlayingList as ListScreenUiState.Success).movies) { _, movie ->
                            MovieItem(movie, navController)
                        }
                    }
                }

                is ListScreenUiState.Failure -> {}
            }
        }

    }
}