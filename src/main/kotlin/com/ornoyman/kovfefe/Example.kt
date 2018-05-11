package com.ornoyman.kovfefe

data class Movie(
    val overview: String,
    val originalLanguage: String,
    val originalTitle: String,
    val video: Boolean,
    val title: String,
    val genreIds: List<Int>,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val popularity: Double,
    val voteAverage: Double,
    val id: Int,
    val adult: Boolean,
    val voteCount: Int
)

val movie = Movie(
    overview = "",
    originalLanguage = "",
    originalTitle = "",
    video = true,
    title = "",
    genreIds = listOf(),
    posterPath = "",
    backdropPath = "",
    releaseDate = "",
    popularity = 9.8,
    voteAverage = 9.5,
    id = 42,
    adult = false,
    voteCount = 10_000
)

// We have the generate Movie data type with fixed 'id' and 'title' and any valid values for the rest of the fields