package com.pakt_games.myapplication.ui.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.myapplication.R
import com.pakt_games.myapplication.ui.movielist.model.Movie

class MovieListRecyclerAdapter(private val movieList: List<Movie>, private var listener: IMovieListRecyclerViewListener) : RecyclerView.Adapter<MovieListRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListRecyclerViewHolder {
        return MovieListRecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_fragment_recycler_item_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieListRecyclerViewHolder, position: Int) {
        holder.bind(movieList[position], listener)
    }

    override fun getItemCount() = this.movieList.size
}
