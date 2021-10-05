package com.pakt_games.myapplication.ui.moviedetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.pakt_games.myapplication.base.BaseViewModel
import com.pakt_games.myapplication.db.MovieDataBase
import com.pakt_games.myapplication.ui.movielist.model.FavoriteMovies
import com.pakt_games.myapplication.ui.movielist.model.Movie
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application) : BaseViewModel(application){

    val movieLiveData= MutableLiveData<Movie>()

    fun getRoomData(uuid: Int)
    {
        launch {
            val dao = MovieDataBase(getApplication()).movieDAO()
            val movie=dao.getMovie(uuid)
            movieLiveData.value=movie
        }
    }
}
