package com.alejandro.tmdbmovies.presentation.movieDetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @since 1.0.0
 *
 * createdDate 26/04/2021
 * updatedDate 26/04/2021
 *
 * VIEWMODEL para el manejo de la informacion de la vista de DETALLE de PELICULA
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(): ViewModel()
{
    private val mMovieImageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    private var mMovieImageUrl: String = ""
    private var mMovieTitle: String = ""
    private var mMovieReleaseDate: String = ""
    private var mMovieLanguage: String = ""
    private var mMovieDescription: String = ""

    ////////////////////////////
    ///                      ///
    ///         SAVE         ///
    ///                      ///
    ////////////////////////////

    fun saveMovieData(
        imageUrl: String,
        title: String,
        releaseDate: String,
        language: String,
        description: String
    )
    {
        mMovieImageUrl = imageUrl
        mMovieTitle = title
        mMovieReleaseDate = releaseDate
        mMovieLanguage = language
        mMovieDescription = description
    }

    ////////////////////////////
    ///                      ///
    ///         GETS         ///
    ///                      ///
    ////////////////////////////

    fun getMovieImageUrl(): String
    {
        return mMovieImageBaseUrl + mMovieImageUrl
    }

    fun getMovieTitle(): String
    {
        return mMovieTitle
    }

    fun getMovieReleaseDate(): String
    {
        return "Fecha de Estreno: $mMovieReleaseDate"
    }

    fun getMovieLanguage(): String
    {
        return "Idioma: $mMovieLanguage"
    }

    fun getMovieDescription(): String
    {
        return mMovieDescription
    }
}