package com.alejandro.tmdbmovies.core

import java.lang.Exception

sealed class StatusCaller<out T>
{
    class Loading<out T> : StatusCaller<T>()
    data class Success<out T>(val data: T) : StatusCaller<T>()
    data class Failure(val exception: Exception) : StatusCaller<Nothing>()
}
