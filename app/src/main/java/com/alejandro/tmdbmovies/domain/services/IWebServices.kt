package com.alejandro.tmdbmovies.domain.services

import com.alejandro.tmdbmovies.data.model.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IWebServices
{
    @GET("top_rated")
    suspend fun obtainTopRatedMovies(@Query("api_key") apiKey: String): MoviesResponse

    @GET("popular")
    suspend fun obtainPopularMovies(@Query("api_key") apiKey: String): MoviesResponse
}