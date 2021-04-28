package com.alejandro.tmdbmovies.injection

import com.alejandro.tmdbmovies.data.local.ILocalDataSource
import com.alejandro.tmdbmovies.data.local.LocalDataSourceImpl
import com.alejandro.tmdbmovies.data.remote.IRemoteDataSource
import com.alejandro.tmdbmovies.data.remote.RemoteDataSourceImpl
import com.alejandro.tmdbmovies.domain.repository.IMovieRepository
import com.alejandro.tmdbmovies.domain.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ActivityModule
{
    @Binds
    abstract fun bindRepositoryImpl(repositoryImpl: MovieRepositoryImpl): IMovieRepository

    @Binds
    abstract fun bindLocalDataSourceImpl(dataSourceImpl: LocalDataSourceImpl): ILocalDataSource

    @Binds
    abstract fun bindRemoteDataSourceImpl(remoteDataSourceImpl: RemoteDataSourceImpl): IRemoteDataSource
}