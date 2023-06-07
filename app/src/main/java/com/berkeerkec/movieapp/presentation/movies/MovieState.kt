package com.berkeerkec.movieapp.presentation.movies

import com.berkeerkec.movieapp.domain.model.Movie

data class MovieState(
    val isLoading : Boolean = false,
    val movieList : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "batman"
)
