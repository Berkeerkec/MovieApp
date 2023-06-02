package com.berkeerkec.movieapp.domain.use_case.get_movies

import com.berkeerkec.movieapp.data.remote.dto.toMovieList
import com.berkeerkec.movieapp.domain.model.Movie
import com.berkeerkec.movieapp.domain.repository.MovieRepository
import com.berkeerkec.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository : MovieRepository
) {

    fun executeGetMovies(searchString : String) : Flow<Resource<List<Movie>>> = flow {

        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(searchString)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error(message = "No movie found!"))
            }
        }catch (e : IOError){
            emit(Resource.Error(message = "No internet connection!"))
        }catch (e : HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}