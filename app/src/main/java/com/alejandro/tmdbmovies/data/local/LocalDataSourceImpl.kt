package com.alejandro.tmdbmovies.data.local

import com.alejandro.tmdbmovies.data.local.dao.IMovieDao
import com.alejandro.tmdbmovies.data.local.entity.MovieEntity
import com.alejandro.tmdbmovies.data.local.entity.toMovie
import com.alejandro.tmdbmovies.data.model.Movie
import com.alejandro.tmdbmovies.data.model.response.MoviesResponse
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val movieDao: IMovieDao) : ILocalDataSource
{
    override suspend fun saveMovies(movieList: List<MovieEntity>)
    {
        movieList.forEach { movieEntity ->
            movieDao.insertMovie(movieEntity)
        }
    }

    override suspend fun getTopRatedMovies(): MoviesResponse
    {
        val movieList = mutableListOf<Movie>()

        movieDao.getByType("toprated").forEach { movieEntity ->

            movieList.add(movieEntity.toMovie())
        }

        return MoviesResponse(movieList)
    }

    override suspend fun getPopularMovies(): MoviesResponse
    {
        val movieList = mutableListOf<Movie>()

        movieDao.getByType("popular").forEach { movieEntity ->

            movieList.add(movieEntity.toMovie())
        }

        return MoviesResponse(movieList)
    }
}