package com.pakt_games.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pakt_games.myapplication.ui.movielist.model.FavoriteMovies
import com.pakt_games.myapplication.ui.movielist.model.Movie

@Database(entities = arrayOf(Movie::class) , version = 1)
abstract class MovieDataBase: RoomDatabase() {

    abstract fun movieDAO() :MovieDAO

    companion object{
        //Volatile= if you want using instance in all project
        @Volatile private var instance: MovieDataBase?=null

        private val lock = Any()
        //Basic Singleton
        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: createDatabase(context).also {
                instance=it
            }
        }
        //Creating Database
        private fun createDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java, "movieDataBase").build()
    }

}