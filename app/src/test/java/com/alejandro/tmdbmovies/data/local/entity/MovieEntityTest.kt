package com.alejandro.tmdbmovies.data.local.entity

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class MovieEntityTest
{
    ////////////////////////////
    ///                      ///
    ///        SETUP         ///
    ///                      ///
    ////////////////////////////

    @Before
    fun setup()
    {
        MockitoAnnotations.openMocks(this)
    }

    ////////////////////////////
    ///                      ///
    ///         TEST         ///
    ///                      ///
    ////////////////////////////

    @Test
    fun givenMovieEntityDataWhenTitleIsValidThenCreateMovieEntity()
    {
        var isCreate = true

        try
        {
            MovieEntity(title = "Primera pelicula")
        }
        catch (e: Exception)
        {
            isCreate = false
        }

        Assert.assertTrue(isCreate)
    }

    @Test
    fun givenMovieEntityDataWhenTitleIsEmptyThenReturnException()
    {
        var isCreate = true

        try
        {
            MovieEntity()
        }
        catch (e: Exception)
        {
            isCreate = false
        }

        Assert.assertFalse(isCreate)
    }
}