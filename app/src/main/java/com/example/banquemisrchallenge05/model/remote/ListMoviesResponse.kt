package com.example.banquemisrchallenge05.model.remote


data class ListMoviesResponse(
    var results:List<Movie>
)

data class Movie(
    var id: Long,
    var title: String,
    var release_date: String,
    var poster_path: String
)