package com.alejandro.tmdbmovies.injection

import android.content.Context
import androidx.room.Room
import com.alejandro.tmdbmovies.data.local.database.MovieDatabase
import com.alejandro.tmdbmovies.core.ApiConstants
import com.alejandro.tmdbmovies.data.remote.service.IWebServices
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Provides
    @Singleton
    fun provideRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movie_table"
        ).build()

    @Provides
    @Singleton
    fun provideMovieDao(database: MovieDatabase) = database.movieDao()

    @Provides
    @Singleton
    fun provideRetrofitClient(): IWebServices = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build().create(IWebServices::class.java)
}