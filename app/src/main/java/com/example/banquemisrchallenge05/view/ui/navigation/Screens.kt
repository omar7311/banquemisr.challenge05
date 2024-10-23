package com.example.banquemisrchallenge05.view.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, val title: String, val icon: ImageVector) {
    object NowPlaying : Screens("nowPlaying", "Now Playing", Icons.Filled.PlayArrow)
    object Popular : Screens("popular", "Popular", Icons.Filled.Star)
    object Upcoming : Screens("upcoming", "Upcoming", Icons.Filled.DateRange)
    object MovieDetails : Screens("movieDetails", "Movie Details", Icons.Filled.Info)

}