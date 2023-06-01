package com.berkeerkec.movieapp.data.repository

import com.berkeerkec.movieapp.data.remote.MovieApi
import com.berkeerkec.movieapp.data.remote.dto.MovieDetailDto
import com.berkeerkec.movieapp.data.remote.dto.MoviesDto
import com.berkeerkec.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api : MovieApi
): MovieRepository {
    override suspend fun getMovies(searchString: String): MoviesDto {
        return api.getMovies(searchString = searchString)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }
}