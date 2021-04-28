package com.alejandro.tmdbmovies.presentation.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.alejandro.tmdbmovies.core.StatusCaller
import com.alejandro.tmdbmovies.domain.repository.IMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: IMovieRepository) : ViewModel()
{
    fun fetchPopularMovies() = liveData(Dispatchers.IO) {

        emit(StatusCaller.Loading())

        try
        {
            val movieResponse = repository.obtainPopularMovies()

            emit(StatusCaller.Success(movieResponse.movieList))
        }
        catch (e: Exception)
        {
            emit(StatusCaller.Failure(e))
        }
    }

    fun fetchTopRatedMovies() = liveData(Dispatchers.IO) {

        emit(StatusCaller.Loading())

        try
        {
            val movieResponse = repository.obtainTopRatedMovies()

            emit(StatusCaller.Success(movieResponse.movieList))
        }
        catch (e: Exception)
        {
            emit(StatusCaller.Failure(e))
        }
    }
}