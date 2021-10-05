package com.pakt_games.myapplication.ui.movielist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "release_data")
    val release_date : String,
    @ColumnInfo(name = "vote_average")
    val vote_average : Double,
    @ColumnInfo(name = "vote_count")
    val vote_count : Int,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path : String,
    @ColumnInfo(name = "poster_path")
    val poster_path : String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}