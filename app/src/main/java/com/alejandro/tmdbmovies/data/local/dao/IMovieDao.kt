package com.alejandro.tmdbmovies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alejandro.tmdbmovies.data.local.entity.MovieEntity

@Dao
interface IMovieDao
{
    @Query("SELECT * FROM movieentity")
    suspend fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movieentity WHERE type LIKE :type")
    suspend fun getByType(type: String): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)
}