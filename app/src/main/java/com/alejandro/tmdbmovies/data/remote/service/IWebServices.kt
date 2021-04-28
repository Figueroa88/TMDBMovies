package com.alejandro.tmdbmovies.data.remote.service

import com.alejandro.tmdbmovies.data.model.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IWebServices
{
    @GET("movie/top_rated")
    suspend fun obtainTopRatedMovies(@Query("api_key") apiKey: String): MoviesResponse

    @GET("movie/popular")
    suspend fun obtainPopularMovies(@Query("api_key") apiKey: String): MoviesResponse
}