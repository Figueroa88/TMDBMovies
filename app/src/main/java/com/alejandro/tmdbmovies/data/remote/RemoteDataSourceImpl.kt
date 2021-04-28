package com.alejandro.tmdbmovies.data.remote

import com.alejandro.tmdbmovies.data.model.response.MoviesResponse
import com.alejandro.tmdbmovies.core.ApiConstants
import com.alejandro.tmdbmovies.data.remote.service.IWebServices
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val webService: IWebServices) :
    IRemoteDataSource
{
    override suspend fun getTopRatedMovies(): MoviesResponse =
        webService.obtainTopRatedMovies(ApiConstants.API_KEY)

    override suspend fun getPopularMovies(): MoviesResponse =
        webService.obtainPopularMovies(ApiConstants.API_KEY)
}