[![Build Status](https://travis-ci.org/restor1/Kovfefe.svg?branch=master)](https://travis-ci.org/restor1/Kovfefe)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/3b5d99686df447eea2d9c73d51085966)](https://www.codacy.com/app/reuven.lichtenstein/Kovfefe?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=RubyLichtenstein/Kovfefe&amp;utm_campaign=Badge_Grade)


#### Kovfefe

### Kotlin library for genrating data types.

### Motivation 
Many times writing tests requires generating data types which can be tedious.
This library aims at making generating data for tests easier.

### Examaple
```kotlin
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
```

#### We have the generate Movie data type with fixed 'id' and 'title' and any valid values for the rest of the fields
##### Before
```kotlin
val movie = Movie(
    overview = "",
    originalLanguage = "",
    originalTitle = "",
    video = true,
    title = "Avengers: Infinity War",
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
```
##### After
```kotlin
val movie = generate<Movie>().copy(id = 42, title = "Avengers: Infinity War")          
```

