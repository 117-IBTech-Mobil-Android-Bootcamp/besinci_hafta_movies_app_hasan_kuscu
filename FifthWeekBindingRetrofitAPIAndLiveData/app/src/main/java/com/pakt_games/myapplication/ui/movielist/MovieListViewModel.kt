package com.pakt_games.myapplication.ui.movielist

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import com.pakt_games.myapplication.base.BaseViewModel
import com.pakt_games.myapplication.db.MovieDataBase
import com.pakt_games.myapplication.repository.MovieRepository
import com.pakt_games.myapplication.ui.movielist.model.Movie
import com.pakt_games.myapplication.ui.movielist.model.MovieListViewStateModel
import com.pakt_games.myapplication.util.API_KEY
import kotlinx.coroutines.launch

class MovieListViewModel(application: Application) : BaseViewModel(application) {


    val moviesResponse = MediatorLiveData<MovieListViewStateModel>()
    val movieRepository = MovieRepository()

    init {
        movieRepository.getAllMovies(API_KEY)

        moviesResponse.addSource(movieRepository.movieList) {
            moviesResponse.value = MovieListViewStateModel(it)
            saveToDataInSQLite(it.movies)
        }
    }

    private fun saveToDataInSQLite(movieList:List<Movie>){
        launch {
            val dao=MovieDataBase(getApplication()).movieDAO()
            dao.deleteAllMovies()
            val uuidList = dao.insertAll(*movieList.toTypedArray())
            dao.getAllMovies()
            var i=0
            while (i<movieList.size) {
                movieList[i].uuid = uuidList[i].toInt()
                i=i+1
            }
        }
    }
}