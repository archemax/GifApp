package com.example.gifapp

data class MovieDetails(
    val id: Int,
    val overview: String,
    val release_date: String,
    val popularity: Double,
    val poster_path: Any,
    val title: String,
    val vote_average: Double,
    val backdrop_path: String
)
