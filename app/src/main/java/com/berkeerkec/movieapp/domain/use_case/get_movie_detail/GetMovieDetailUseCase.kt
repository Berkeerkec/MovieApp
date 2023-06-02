package com.berkeerkec.movieapp.domain.use_case.get_movie_detail

import com.berkeerkec.movieapp.data.remote.dto.toMovieDetail
import com.berkeerkec.movieapp.data.remote.dto.toMovieList
import com.berkeerkec.movieapp.domain.model.Movie
import com.berkeerkec.movieapp.domain.model.MovieDetail
import com.berkeerkec.movieapp.domain.repository.MovieRepository
import com.berkeerkec.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository : MovieRepository
) {

    fun executeGetMovieDetail(imdbId : String) : Flow<Resource<MovieDetail>> = flow {

        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId = imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))

        }catch (e : IOError){
            emit(Resource.Error(message = "No internet connection!"))
        }catch (e : HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}