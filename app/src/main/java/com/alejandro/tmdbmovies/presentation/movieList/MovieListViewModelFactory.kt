package com.alejandro.tmdbmovies.presentation.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alejandro.tmdbmovies.domain.repository.IMovieRepository

class MovieListViewModelFactory(private val repository: IMovieRepository) :
    ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return modelClass.getConstructor(IMovieRepository::class.java).newInstance(repository)
    }
}