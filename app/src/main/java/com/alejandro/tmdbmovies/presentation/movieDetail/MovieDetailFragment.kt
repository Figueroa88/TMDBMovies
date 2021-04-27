package com.alejandro.tmdbmovies.presentation.movieDetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.alejandro.tmdbmovies.R
import com.alejandro.tmdbmovies.core.BaseFragment
import com.alejandro.tmdbmovies.databinding.FMovieDetailBinding
import com.alejandro.tmdbmovies.presentation.MainActivity
import com.bumptech.glide.Glide

class MovieDetailFragment : BaseFragment(R.layout.f_movie_detail)
{
    private lateinit var mViewBinding: FMovieDetailBinding
    private val fragmentArguments by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mViewBinding = FMovieDetailBinding.bind(view)

        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${fragmentArguments.movieUrl}").centerCrop().into(mViewBinding.ivMovieImage)

        mViewBinding.tvMovieTitle.text = fragmentArguments.title
        mViewBinding.tvMovieReleaseDate.text = "Release Date: ${fragmentArguments.releaseDate}"
        mViewBinding.tvMovieLanguage.text = "Idioma: ${fragmentArguments.language}"
        mViewBinding.tvMovieDescription.text = fragmentArguments.overview
    }

    override fun onStart()
    {
        super.onStart()

        if (activity != null && activity is MainActivity)
        {
            (activity as MainActivity).showOrHideBottomBar(false)
        }
    }
}