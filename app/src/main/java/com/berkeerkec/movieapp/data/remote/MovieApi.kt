package com.berkeerkec.movieapp.data.remote

import com.berkeerkec.movieapp.data.remote.dto.MovieDetailDto
import com.berkeerkec.movieapp.data.remote.dto.MoviesDto
import com.berkeerkec.movieapp.util.Constansts.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    //https://www.omdbapi.com/?i=tt3896198&apikey=8b47c848
    //https://www.omdbapi.com/?s=batman&apikey=8b47c848

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MoviesDto
    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : MovieDetailDto
}