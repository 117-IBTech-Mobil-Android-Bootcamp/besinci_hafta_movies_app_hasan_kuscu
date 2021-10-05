package com.pakt_games.myapplication.ui.movielist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.myapplication.databinding.MovieFragmentRecyclerItemRowBinding

import com.pakt_games.myapplication.ui.movielist.model.Movie

class MovieListRecyclerViewHolder(private val binding: MovieFragmentRecyclerItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie, onClicklistener: IMovieListRecyclerViewListener) {
        binding.model = movie
        binding.listener = onClicklistener
        binding.executePendingBindings()
    }
}