package com.alejandro.tmdbmovies.data.model.response

import com.alejandro.tmdbmovies.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MoviesResponse(@SerializedName("results") val movieList: List<Movie> = listOf())