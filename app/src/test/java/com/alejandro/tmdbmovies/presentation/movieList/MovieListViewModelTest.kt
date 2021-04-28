package com.alejandro.tmdbmovies.presentation.movieList

import androidx.lifecycle.Observer
import com.alejandro.tmdbmovies.core.StatusCaller
import com.alejandro.tmdbmovies.data.model.Movie
import com.alejandro.tmdbmovies.domain.repository.IMovieRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*


class MovieListViewModelTest
{
    //Variables

    private lateinit var mViewModel:MovieListViewModel

    @Mock
    private lateinit var mRepository:IMovieRepository

    @Mock
    private lateinit var mObserver:Observer<StatusCaller<List<Movie>>>

    @Captor
    private lateinit var mMoviesCaptor: ArgumentCaptor<StatusCaller<List<Movie>>>

    //@get:Rule
    //public val instantExecutorRule = InstantTaskExecutorRule()

    ////////////////////////////
    ///                      ///
    ///        SETUP         ///
    ///                      ///
    ////////////////////////////

    @Before
    fun setup()
    {
        MockitoAnnotations.openMocks(this)

        mViewModel = MovieListViewModel(mRepository)
    }

    ////////////////////////////
    ///                      ///
    ///         TEST         ///
    ///                      ///
    ////////////////////////////
}