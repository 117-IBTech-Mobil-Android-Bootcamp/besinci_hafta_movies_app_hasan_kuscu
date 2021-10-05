package com.pakt_games.myapplication.ui.movielist.adapter

import android.view.View


interface IMovieListRecyclerViewListener {
    fun onclick(view: View, uuid: Int, movieTitle: String)
}