package com.example.banquemisrchallenge05.model.remote


data class ListMoviesResponse(
    var results:List<Movie>
)

open class Movie(
    open var id: Long,
   open var title: String,
   open var release_date: String,
   open var poster_path: String
)