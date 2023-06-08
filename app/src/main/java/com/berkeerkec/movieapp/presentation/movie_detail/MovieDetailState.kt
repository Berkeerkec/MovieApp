package com.berkeerkec.movieapp.presentation.movie_detail

import com.berkeerkec.movieapp.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = ""
)