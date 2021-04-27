package com.alejandro.tmdbmovies.data

import com.alejandro.tmdbmovies.data.model.response.MoviesResponse

interface IDataSource
{
    suspend fun getTopRatedMovies(): MoviesResponse

    suspend fun getPopularMovies(): MoviesResponse
}