package com.alejandro.tmdbmovies.domain.repository

import com.alejandro.tmdbmovies.data.model.response.MoviesResponse

interface IMovieRepository
{
    suspend fun obtainTopRatedMovies(): MoviesResponse

    suspend fun obtainPopularMovies(): MoviesResponse
}