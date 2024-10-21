package com.example.banquemisrchallenge05.view.ListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.banquemisrchallenge05.view.ui.navigation.Screens
import com.example.banquemisrchallenge05.view.ui.uistate.UiState
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
                is UiState.Loading -> {}
                is UiState.Success -> {
                    LazyHorizontalGrid(
                        rows = GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize().padding(4.dp)
                    ) {
                        itemsIndexed((nowPlayingList as UiState.Success).movies) { _, movie ->
                            MovieItem(movie, navController)
                        }
                    }
                }

                is UiState.Failure -> {}
            }
        }

    }
}