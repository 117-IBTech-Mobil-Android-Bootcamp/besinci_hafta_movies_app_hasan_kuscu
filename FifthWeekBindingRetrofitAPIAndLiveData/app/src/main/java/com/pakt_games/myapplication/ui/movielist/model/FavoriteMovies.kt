package com.pakt_games.myapplication.ui.movielist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class FavoriteMovies(
    @ColumnInfo(name = "title")
    val title : String,
) {
    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}