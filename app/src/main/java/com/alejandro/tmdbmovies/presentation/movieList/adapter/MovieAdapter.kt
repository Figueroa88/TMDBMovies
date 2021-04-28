package com.alejandro.tmdbmovies.presentation.movieList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.alejandro.tmdbmovies.core.BaseViewHolder
import com.alejandro.tmdbmovies.data.model.Movie
import com.alejandro.tmdbmovies.databinding.ItemRowMovieBinding
import com.bumptech.glide.Glide


/**
 * @since 1.0.0
 *
 * createdDate 26/04/2021
 * updatedDate 26/04/2021
 *
 * ADAPTER para el manejo de los elementos del listado de peliculas populares y top rated
 */
class MovieAdapter(
    private val mItemList: List<Movie> = mutableListOf(),
    private val mRowListener: IItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>()
{
    ////////////////////////////
    ///                      ///
    ///       OVERRIDE       ///
    ///                      ///
    ////////////////////////////

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder
    {
        val itemBinding =
            ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MoviesViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int)
    {
        holder.bind(mItemList[position])
    }

    override fun getItemCount(): Int
    {
        return mItemList.size
    }

    ////////////////////////////
    ///                      ///
    ///     VIEW HOLDER      ///
    ///                      ///
    ////////////////////////////

    inner class MoviesViewHolder(private val binding: ItemRowMovieBinding, val context: Context) :
        BaseViewHolder<Movie>(binding.root)
    {
        override fun bind(itemView: Movie)
        {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${itemView.posterPath}")
                .centerCrop().into(binding.ivMovieImage)

            binding.tvMovieTitle.text = itemView.title
            binding.tvMovieOverride.text = itemView.overview

            onClickRowMovie(binding.clMovieRowContent, itemView)
        }
    }

    ////////////////////////////
    ///                      ///
    ///       EVENTS         ///
    ///                      ///
    ////////////////////////////

    private fun onClickRowMovie(clContent: ConstraintLayout, selectedMovie: Movie)
    {
        clContent.setOnClickListener {

            mRowListener.onMovieClick(selectedMovie)
        }
    }

    ////////////////////////////
    ///                      ///
    ///   EVENT INTERFACE    ///
    ///                      ///
    ////////////////////////////

    interface IItemClickListener
    {
        fun onMovieClick(movie: Movie)
    }
}