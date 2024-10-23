package com.example.banquemisrchallenge05.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.banquemisrchallenge05.model.remote.Movie

@Entity(tableName = "nowPlaying_movies")
data class NowPlayingMovie(
    @PrimaryKey
    override var id: Long,
    override var title: String,
    override var release_date: String,
   override var poster_path: String
) : Movie(id, title, release_date, poster_path)
@Entity(tableName = "popular_movies")
data class PopularMovie(
    @PrimaryKey
   override var id: Long,
    override var title: String,
   override var release_date: String,
   override var poster_path: String
) : Movie(id, title, release_date, poster_path)
@Entity(tableName = "upcoming_movies")
data class UpcomingMovie(
    @PrimaryKey
    override var id: Long,
    override var title: String,
    override var release_date: String,
    override var poster_path: String
) : Movie(id, title, release_date, poster_path)