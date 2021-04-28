package com.alejandro.tmdbmovies.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alejandro.tmdbmovies.data.local.dao.IMovieDao
import com.alejandro.tmdbmovies.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase()
{
    abstract fun movieDao(): IMovieDao
}