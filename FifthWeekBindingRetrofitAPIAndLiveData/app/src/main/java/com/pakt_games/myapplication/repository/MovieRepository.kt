package com.pakt_games.myapplication.repository

import androidx.lifecycle.MutableLiveData
import com.pakt_games.myapplication.network.ServiceConnector
import com.pakt_games.myapplication.network.response.MovieListResponse
import com.pakt_games.myapplication.network.BaseCallBack

class MovieRepository {

    val movieList = MutableLiveData<MovieListResponse>()

    fun getAllMovies(apiKey : String){
        ServiceConnector.restInterface.getPopularMovies(apiKey).enqueue(object  : BaseCallBack<MovieListResponse>(){
            override fun onSuccess(data: MovieListResponse) {
                movieList.postValue(data)
            }
        })
    }
}