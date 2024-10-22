package com.example.banquemisrchallenge05.model.local

import androidx.room.Entity

@Entity(tableName = "nowPlaying_movies")
data class NowPlayingMovie(
    var id: Long,
    var title: String,
    var release_date: String,
    var poster_path: String
)
@Entity(tableName = "popular_movies")
data class PopularMovie(
    var id: Long,
    var title: String,
    var release_date: String,
    var poster_path: String
)
@Entity(tableName = "upcoming_movies")
data class UpcomingMovie(
    var id: Long,
    var title: String,
    var release_date: String,
    var poster_path: String
)