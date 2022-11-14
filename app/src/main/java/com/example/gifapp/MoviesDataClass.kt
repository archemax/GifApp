package com.example.gifapp

data class MoviesDataClass(
    val page: Int,
    val results: List<MovieResponse>,
    val total_pages: Int,
    val total_results: Int
)