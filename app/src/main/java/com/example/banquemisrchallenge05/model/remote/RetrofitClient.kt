package com.example.banquemisrchallenge05.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL="https://api.themoviedb.org/3/movie/"
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val apiServices= retrofit.create(ApiServices::class.java)
}