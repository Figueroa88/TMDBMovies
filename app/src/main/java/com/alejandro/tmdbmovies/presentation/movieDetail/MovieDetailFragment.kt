package com.alejandro.tmdbmovies.presentation.movieDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.alejandro.tmdbmovies.R
import com.alejandro.tmdbmovies.core.BaseFragment
import com.alejandro.tmdbmovies.databinding.FMovieDetailBinding
import com.alejandro.tmdbmovies.presentation.MainActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


/**
 * @since 1.0.0
 *
 * createdDate 27/04/2021
 * updatedDate 27/04/2021
 *
 * FRAGMENT para el manejo del detalle de una pelicula
 */
@AndroidEntryPoint
class MovieDetailFragment : BaseFragment(R.layout.f_movie_detail)
{
    private lateinit var mViewBinding: FMovieDetailBinding
    private val fragmentArguments by navArgs<MovieDetailFragmentArgs>()
    private val mViewModel by viewModels<MovieDetailViewModel>()

    ////////////////////////////
    ///                      ///
    ///       OVERRIDE       ///
    ///                      ///
    ////////////////////////////

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mViewBinding = FMovieDetailBinding.bind(view)

        //Init

        initView()
    }

    override fun onStart()
    {
        super.onStart()

        if (activity != null && activity is MainActivity)
        {
            (activity as MainActivity).showOrHideBottomBar(false)
        }
    }

    ////////////////////////////
    ///                      ///
    ///         INIT         ///
    ///                      ///
    ////////////////////////////

    private fun initView()
    {
        mViewModel.saveMovieData(
            fragmentArguments.movieUrl,
            fragmentArguments.title,
            fragmentArguments.releaseDate,
            fragmentArguments.language,
            fragmentArguments.overview
        )

        Glide.with(requireContext()).load(mViewModel.getMovieImageUrl()).centerCrop()
            .into(mViewBinding.ivMovieImage)

        mViewBinding.tvMovieTitle.text = mViewModel.getMovieTitle()
        mViewBinding.tvMovieReleaseDate.text = mViewModel.getMovieReleaseDate()
        mViewBinding.tvMovieLanguage.text = mViewModel.getMovieLanguage()
        mViewBinding.tvMovieDescription.text = mViewModel.getMovieDescription()
    }
}