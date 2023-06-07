package com.berkeerkec.movieapp.presentation.movies

sealed class MoviesEvent {

    data class Search(val searchString : String) : MoviesEvent()
}