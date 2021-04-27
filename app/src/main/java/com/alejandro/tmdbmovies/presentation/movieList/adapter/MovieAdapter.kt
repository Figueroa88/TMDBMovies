package com.alejandro.tmdbmovies.presentation.movieList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandro.tmdbmovies.core.BaseViewHolder
import com.alejandro.tmdbmovies.data.model.Movie
import com.alejandro.tmdbmovies.databinding.ItemRowMovieBinding
import com.bumptech.glide.Glide

class MovieAdapter(
    private val mItemList: List<Movie> = mutableListOf(),
    private val mRowListener: IItemClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*>
    {
        val itemBinding =
            ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MoviesViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int)
    {
        when (holder)
        {
            is MoviesViewHolder -> holder.bind(mItemList[position])
        }
    }

    override fun getItemCount(): Int
    {
        return mItemList.size
    }

    private inner class MoviesViewHolder(val binding: ItemRowMovieBinding, val context: Context) :
        BaseViewHolder<Movie>(binding.root)
    {
        override fun bind(itemView: Movie)
        {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${itemView.posterPath}")
                .centerCrop().into(binding.ivMovieImage)

            binding.tvMovieTitle.text = itemView.title
            binding.tvMovieOverride.text = itemView.overview

            binding.clMovieRowContent.setOnClickListener {

                mRowListener.onMovieClick(itemView)
            }
        }
    }

    interface IItemClickListener
    {
        fun onMovieClick(movie: Movie)
    }
}