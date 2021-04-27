package com.alejandro.tmdbmovies.data.local

import com.alejandro.tmdbmovies.data.IDataSource
import com.alejandro.tmdbmovies.data.local.entity.MovieEntity

interface ILocalDataSource : IDataSource
{
    suspend fun saveMovies(movieList: List<MovieEntity>)
}