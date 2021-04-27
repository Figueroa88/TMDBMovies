package com.alejandro.tmdbmovies.presentation.movieList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alejandro.tmdbmovies.R
import com.alejandro.tmdbmovies.core.BaseFragment
import com.alejandro.tmdbmovies.core.StatusCaller
import com.alejandro.tmdbmovies.data.local.LocalDataSourceImpl
import com.alejandro.tmdbmovies.data.local.database.MovieDatabase
import com.alejandro.tmdbmovies.data.model.Movie
import com.alejandro.tmdbmovies.data.remote.RemoteDataSourceImpl
import com.alejandro.tmdbmovies.databinding.FMovieListBinding
import com.alejandro.tmdbmovies.domain.client.RetrofitClient
import com.alejandro.tmdbmovies.domain.repository.MovieRepositoryImpl
import com.alejandro.tmdbmovies.presentation.MainActivity
import com.alejandro.tmdbmovies.presentation.movieList.adapter.MovieAdapter


class MovieTopListFragment : BaseFragment(R.layout.f_movie_list), MovieAdapter.IItemClickListener
{
    private lateinit var mBinding: FMovieListBinding

    private val mViewModel by viewModels<MovieListViewModel> {
        MovieListViewModelFactory(
            MovieRepositoryImpl(
                RemoteDataSourceImpl(RetrofitClient.webService),
                LocalDataSourceImpl(MovieDatabase.getDatabase(requireContext()).movieDao())
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mBinding = FMovieListBinding.bind(view)

        mBinding.rvMovieList.visibility = View.GONE
        mBinding.sflLoading.visibility = View.VISIBLE

        mViewModel.fetchTopRatedMovies().observe(viewLifecycleOwner, { result ->

            when(result)
            {
                is StatusCaller.Loading -> {

                    mBinding.sflLoading.startShimmerAnimation()
                }

                is StatusCaller.Success -> {

                    mBinding.sflLoading.stopShimmerAnimation()

                    mBinding.rvMovieList.visibility = View.VISIBLE
                    mBinding.sflLoading.visibility = View.GONE

                    mBinding.rvMovieList.adapter = MovieAdapter(result.data, this)
                }

                is StatusCaller.Failure -> {

                    mBinding.sflLoading.stopShimmerAnimation()

                    mBinding.sflLoading.visibility = View.GONE
                }
            }
        })
    }

    override fun onStart()
    {
        super.onStart()

        if (activity != null && activity is MainActivity)
        {
            (activity as MainActivity).showOrHideBottomBar(true)
        }
    }

    override fun onMovieClick(movie: Movie)
    {
        val action = MovieTopListFragmentDirections.actionTopToDetail(movie.posterPath, movie.backdropPath, movie.title, movie.overview, movie.originalLanguage, movie.releaseDate)

        findNavController().navigate(action)
    }
}