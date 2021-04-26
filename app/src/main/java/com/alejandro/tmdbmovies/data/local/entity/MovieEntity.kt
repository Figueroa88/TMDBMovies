package com.alejandro.tmdbmovies.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class MovieEntity(@PrimaryKey
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
                       val voteCount: Int = -1,
                       val type: String = "")