package com.alejandro.tmdbmovies.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alejandro.tmdbmovies.data.local.dao.IMovieDao
import com.alejandro.tmdbmovies.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase()
{
    abstract fun movieDao(): IMovieDao

    companion object
    {
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase
        {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    MovieDatabase::class.java,
                    "movie_table").build()

            return INSTANCE!!
        }

        fun destroyInstance()
        {
            INSTANCE = null
        }
    }
}