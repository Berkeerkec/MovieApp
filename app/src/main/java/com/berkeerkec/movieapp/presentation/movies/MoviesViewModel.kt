package com.berkeerkec.movieapp.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkeerkec.movieapp.domain.use_case.get_movies.GetMovieUseCase
import com.berkeerkec.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovieUseCase : GetMovieUseCase
): ViewModel() {

    private val _state = mutableStateOf<MovieState>(MovieState())
    val state : State<MovieState> = _state

    private var job : Job? = null

    init {
        getMovies(_state.value.search)
    }

    private fun getMovies(search : String){
        job?.cancel()

        job = getMovieUseCase.executeGetMovies(searchString = search).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = MovieState(movieList = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MovieState(error = it.message ?: "Error!")
                }
                is Resource.Loading ->{
                    _state.value = MovieState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: MoviesEvent){
        when(event){
            is MoviesEvent.Search ->{
                getMovies(event.searchString)
            }
        }
    }
}