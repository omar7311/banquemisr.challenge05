package com.example.banquemisrchallenge05.model.remote

import androidx.room.Entity

@Entity(tableName = "movie_details")
data class MovieDetails(
    var id: Long,
    var original_title: String,
    var release_date: String,
    var backdrop_path:String,
    var poster_path: String,
    var overview:String,
    var runtime:Int,
    var genres:List<genre>
    )

data class genre(
    var id:Long,
    var name:String
)