package com.alejandro.tmdbmovies.domain.repository

import com.alejandro.tmdbmovies.core.InternetCheck
import com.alejandro.tmdbmovies.data.local.ILocalDataSource
import com.alejandro.tmdbmovies.data.local.entity.MovieEntity
import com.alejandro.tmdbmovies.data.model.response.MoviesResponse
import com.alejandro.tmdbmovies.data.model.toMovieEntity
import com.alejandro.tmdbmovies.data.remote.IRemoteDataSource

class MovieRepositoryImpl(
    private val mRemoteDataSource: IRemoteDataSource,
    private val mLocalDataSource: ILocalDataSource
) : IMovieRepository
{
    override suspend fun obtainPopularMovies(): MoviesResponse
    {
        if (InternetCheck.isNetworkAvailable())
        {
            val movieEntityList = mutableListOf<MovieEntity>()

            mRemoteDataSource.getPopularMovies().movieList.forEach { movie ->

                movieEntityList.add(movie.toMovieEntity("popular"))
            }

            mLocalDataSource.saveMovies(movieEntityList)
        }

        return mLocalDataSource.getPopularMovies()
    }

    override suspend fun obtainTopRatedMovies(): MoviesResponse
    {
        if (InternetCheck.isNetworkAvailable())
        {
            val movieEntityList = mutableListOf<MovieEntity>()

            mRemoteDataSource.getTopRatedMovies().movieList.forEach { movie ->

                movieEntityList.add(movie.toMovieEntity("toprated"))
            }

            mLocalDataSource.saveMovies(movieEntityList)
        }

        return mLocalDataSource.getTopRatedMovies()
    }
}