package com.alejandro.tmdbmovies.presentation.movieList.popularMovies

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.alejandro.tmdbmovies.core.StatusCaller
import com.alejandro.tmdbmovies.data.model.Movie
import com.alejandro.tmdbmovies.presentation.movieList.BaseMovieListFragment
import com.alejandro.tmdbmovies.presentation.movieList.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint


/**
 * @since 1.0.0
 *
 * createdDate 27/04/2021
 * updatedDate 27/04/2021
 *
 * FRAGMENT para el manejo del listado de las peliculas POPULARES
 */
@AndroidEntryPoint
class MoviePopularListFragment : BaseMovieListFragment()
{
    ////////////////////////////
    ///                      ///
    ///       OVERRIDE       ///
    ///                      ///
    ////////////////////////////

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.fetchPopularMovies().observe(viewLifecycleOwner, { result ->

            when (result)
            {
                is StatusCaller.Loading ->
                {
                    doStatusLoading(mBinding)
                }

                is StatusCaller.Success ->
                {
                    doStatusSuccess(mBinding, result.data.isEmpty())

                    mBinding.rvMovieList.adapter = MovieAdapter(result.data, this)
                }

                is StatusCaller.Failure ->
                {
                    doStatusFailed(mBinding)
                }
            }
        })
    }

    ////////////////////////////
    ///                      ///
    ///      IMPLEMENT       ///
    ///                      ///
    ////////////////////////////

    override fun onMovieClick(movie: Movie)
    {
        val action = MoviePopularListFragmentDirections.actionPopularToDetail(
            movie.posterPath,
            movie.backdropPath,
            movie.title,
            movie.overview,
            movie.originalLanguage,
            movie.releaseDate
        )

        findNavController().navigate(action)
    }
}