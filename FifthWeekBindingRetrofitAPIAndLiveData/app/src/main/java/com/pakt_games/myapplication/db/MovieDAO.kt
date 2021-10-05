package com.pakt_games.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pakt_games.myapplication.ui.movielist.model.FavoriteMovies
import com.pakt_games.myapplication.ui.movielist.model.Movie

@Dao
interface MovieDAO {
    @Insert
    suspend fun insertAll(vararg movie:Movie) : List<Long>
    @Query("SELECT * FROM MOVIE")
    suspend fun getAllMovies() : List<Movie>
    @Query("SELECT * FROM MOVIE WHERE uuid = :MovieId")
    suspend fun getMovie(MovieId : Int) : Movie
    @Query("DELETE FROM MOVIE")
    suspend fun deleteAllMovies()
}