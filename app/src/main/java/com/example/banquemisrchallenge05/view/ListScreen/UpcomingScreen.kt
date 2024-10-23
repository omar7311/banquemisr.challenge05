package com.example.banquemisrchallenge05.view.ListScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.model.NetworkObserver
import com.example.banquemisrchallenge05.view.ui.uistate.ListScreenUiState
import com.example.banquemisrchallenge05.viewmodel.movieslistVM.MoviesListViewModel


@Composable
fun UpcomingScreen(
    networkObserver: NetworkObserver,
    navController: NavHostController,
    moviesListViewModel: MoviesListViewModel,
    key: String
) {
    val isConnected by networkObserver.isConnected.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    val upcomingList by moviesListViewModel.movies.collectAsState()
    val upcomingListFromLocal by moviesListViewModel.moviesFromLocal.collectAsState()

    LaunchedEffect(Unit) {
        moviesListViewModel.getUpcomingMovies(key)
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {},
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            if (isConnected) {
                when (upcomingList) {
                    is ListScreenUiState.Loading -> {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                    is ListScreenUiState.Success -> {
                        LazyHorizontalGrid(
                            rows = GridCells.Fixed(2),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            itemsIndexed((upcomingList as ListScreenUiState.Success).movies) { _, movie ->
                                MovieItem(movie, navController)
                            }
                        }
                    }

                    is ListScreenUiState.Failure -> {
                        Text(
                            text = "Failed to load movies",
                            color = Color.Red,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            else {
                LaunchedEffect(Unit) {
                    moviesListViewModel.getUpcomingFromLocal()
                    snackBarHostState.showSnackbar("No Internet Connection!")
                }
                when (upcomingListFromLocal) {
                    is ListScreenUiState.Loading -> {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                    is ListScreenUiState.Success -> {
                        val movies = (upcomingListFromLocal as ListScreenUiState.Success).movies
                        if (movies.isNotEmpty()) {
                            LazyHorizontalGrid(
                                rows = GridCells.Fixed(2),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp)
                            ) {
                                itemsIndexed(movies) { _, movie ->
                                    MovieItem(movie, navController)
                                }
                            }
                        } else {
                            Text(
                                text = "No Data Found",
                                color = Color.Red,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }

                    is ListScreenUiState.Failure -> {
                        Text(
                            text = "Failed to load local movies",
                            color = Color.Red,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

            }
        }
    }
}