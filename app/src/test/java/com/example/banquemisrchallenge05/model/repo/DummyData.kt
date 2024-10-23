package com.example.banquemisrchallenge05.model.repo

import com.example.banquemisrchallenge05.model.remote.Movie
import com.example.banquemisrchallenge05.model.remote.MovieDetails
import com.example.banquemisrchallenge05.model.remote.genre

val movieListTest= mutableListOf(
    Movie(123,"title1","12-12-2024","poster path 1"),
    Movie(132,"title2","10-10-2024","poster path 2"),
    Movie(231,"title3","8-8-2024","poster path 3")
)
val genres= listOf(genre(11,"drama"))
val movieDetailsListTest= mutableListOf(
    MovieDetails(123,"title1","12-12-2024","backdrop path 1"
        ,"poster path 1","overview 1",102, genres),
    MovieDetails(132,"title2","9-9-2024","backdrop path 2"
        ,"poster path 2","overview 2",103, genres),
    MovieDetails(213,"title3","2-2-2024","backdrop path 3"
        ,"poster path 3","overview 3",105, genres)
)