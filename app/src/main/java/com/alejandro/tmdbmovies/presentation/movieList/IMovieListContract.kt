package com.alejandro.tmdbmovies.presentation.movieList

import com.alejandro.tmdbmovies.databinding.FMovieListBinding

/**
 * @since 1.0.0
 *
 * createdDate 27/04/2021
 * updatedDate 27/04/2021
 *
 * INTERFACE para el manejo de ciertos metodos en los fragmentos del listado
 */
interface IMovieListContract
{
    interface View
    {
        fun doStatusLoading(binding: FMovieListBinding)

        fun doStatusSuccess(binding: FMovieListBinding, isResultDataEmpty:Boolean)

        fun doStatusFailed(binding: FMovieListBinding)
    }
}