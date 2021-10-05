package com.pakt_games.myapplication.ui.movielist.model

import com.pakt_games.myapplication.network.response.MovieListResponse

data class MovieListViewStateModel(val moviesResponse: MovieListResponse){

    fun getList() : List<Movie> = moviesResponse.movies
}