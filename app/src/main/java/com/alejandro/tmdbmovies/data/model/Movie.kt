package com.alejandro.tmdbmovies.data.model

import com.alejandro.tmdbmovies.data.local.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class Movie(
        val id: Int = -1,
        val adult: Boolean = false,
        @SerializedName("backdrop_path")
        val backdropPath: String = "",
        @SerializedName("original_title")
        val originalTitle: String = "",
        @SerializedName("original_language")
        val originalLanguage: String = "",
        val overview: String = "",
        val popularity: Double = -1.0,
        @SerializedName("poster_path")
        val posterPath: String = "",
        @SerializedName("release_date")
        val releaseDate: String = "",
        val title: String = "",
        val video: Boolean = false,
        @SerializedName("vote_average")
        val voteAverage: Double = -1.0,
        @SerializedName("vote_count")
        val voteCount: Int = -1
)
{
    init
    {
        if (title.isEmpty())
        {
            throw IllegalArgumentException("La pelicula debe tener un titulo")
        }
        else if (overview.isEmpty())
        {
            throw IllegalArgumentException("La pelicula debe tener una descripción")
        }
    }
}

fun Movie.toMovieEntity(type: String): MovieEntity = MovieEntity(
        this.id,
        this.adult,
        backdropPath = "",
        this.originalTitle,
        this.originalLanguage,
        this.overview,
        this.popularity,
        this.posterPath,
        this.releaseDate,
        this.title,
        this.video,
        this.voteAverage,
        this.voteCount,
        type = type
)