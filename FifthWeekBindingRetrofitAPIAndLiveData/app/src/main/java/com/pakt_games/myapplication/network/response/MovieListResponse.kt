package com.pakt_games.myapplication.network.response

import com.google.gson.annotations.SerializedName
import com.pakt_games.myapplication.ui.movielist.model.Movie

data class MovieListResponse (
    @SerializedName("results") val movies : List<Movie>
)