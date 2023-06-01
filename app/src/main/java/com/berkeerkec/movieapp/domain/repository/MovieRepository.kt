package com.berkeerkec.movieapp.domain.repository

import com.berkeerkec.movieapp.data.remote.dto.MovieDetailDto
import com.berkeerkec.movieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(searchString : String) : MoviesDto

    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}