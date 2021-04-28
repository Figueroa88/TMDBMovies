package com.alejandro.tmdbmovies.presentation.movieList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alejandro.tmdbmovies.R
import com.alejandro.tmdbmovies.core.BaseFragment
import com.alejandro.tmdbmovies.databinding.FMovieListBinding
import com.alejandro.tmdbmovies.presentation.MainActivity
import com.alejandro.tmdbmovies.presentation.movieList.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint


/**
 * @since 1.0.0
 *
 * createdDate 27/04/2021
 * updatedDate 27/04/2021
 *
 * ABSTRACT CLASS para la herencia de las 2 clases de listado de peliculas (populares y top)
 */
@AndroidEntryPoint
abstract class BaseMovieListFragment : BaseFragment(R.layout.f_movie_list),
    MovieAdapter.IItemClickListener, IMovieListContract.View
{
    //Variables

    protected lateinit var mBinding: FMovieListBinding
    protected val mViewModel by viewModels<MovieListViewModel>()

    ////////////////////////////
    ///                      ///
    ///       OVERRIDE       ///
    ///                      ///
    ////////////////////////////

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mBinding = FMovieListBinding.bind(view)

        assignListVisibility(false)
        assignLoadingVisibility(true)
        assignNotFoundContentVisibility(false)
    }

    override fun onStart()
    {
        super.onStart()

        if (activity != null && activity is MainActivity)
        {
            (activity as MainActivity).showOrHideBottomBar(true)
        }
    }

    ////////////////////////////
    ///                      ///
    ///       METHODS        ///
    ///                      ///
    ////////////////////////////

    private fun assignListVisibility(isVisible: Boolean)
    {
        if (isVisible)
        {
            mBinding.rvMovieList.visibility = View.VISIBLE
        }
        else
        {
            mBinding.rvMovieList.visibility = View.GONE
        }
    }

    private fun assignLoadingVisibility(isVisible: Boolean)
    {
        if (isVisible)
        {
            mBinding.sflLoading.visibility = View.VISIBLE
        }
        else
        {
            mBinding.sflLoading.visibility = View.GONE
        }
    }

    private fun assignNotFoundContentVisibility(isVisible: Boolean)
    {
        if (isVisible)
        {
            mBinding.llDataNotFound.visibility = View.VISIBLE
        }
        else
        {
            mBinding.llDataNotFound.visibility = View.GONE
        }
    }

    ////////////////////////////
    ///                      ///
    ///      IMPLEMENTS      ///
    ///                      ///
    ////////////////////////////

    override fun doStatusLoading(binding: FMovieListBinding)
    {
        binding.sflLoading.startShimmerAnimation()
    }

    override fun doStatusSuccess(binding: FMovieListBinding, isResultDataEmpty: Boolean)
    {
        binding.sflLoading.stopShimmerAnimation()

        assignLoadingVisibility(false)

        if (isResultDataEmpty)
        {
            binding.tvWarningText.text = "No existen peliculas para mostrar o no posee conexión a internet"

            assignListVisibility(false)
            assignNotFoundContentVisibility(true)
        }
        else
        {
            assignListVisibility(true)
            assignNotFoundContentVisibility(false)
        }
    }

    override fun doStatusFailed(binding: FMovieListBinding)
    {
        binding.sflLoading.stopShimmerAnimation()

        binding.tvWarningText.text =
            "No fue posible obtener las peliculas. Por favor, intenta más tarde"

        assignListVisibility(false)
        assignLoadingVisibility(false)
        assignNotFoundContentVisibility(true)
    }
}