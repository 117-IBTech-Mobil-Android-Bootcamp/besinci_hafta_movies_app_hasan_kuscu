package com.pakt_games.myapplication.network

import com.pakt_games.myapplication.network.response.MovieListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieAPI {
    @GET("popular")
    fun getPopularMovies(@Query("api_key") apikey : String) : Call<MovieListResponse>
}