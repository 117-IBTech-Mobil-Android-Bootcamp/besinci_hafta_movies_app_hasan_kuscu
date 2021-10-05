package com.pakt_games.myapplication.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pakt_games.myapplication.R

const val IMAGE_BASE_URL="https://image.tmdb.org/t/p/w500/"

fun ImageView.downloadImage(url:String?, placeholder: CircularProgressDrawable)
{
    //if  image to late coming this screen
    val options= RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)
    Glide.with(context).setDefaultRequestOptions(options).load(IMAGE_BASE_URL+url).into(this)
}

// create progressBar for PlaceHolder
fun createPlaceholder(contex: Context): CircularProgressDrawable
{
    return CircularProgressDrawable(contex).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }
}
@BindingAdapter("android:downloadImage")
fun downloadBindingImage(view: ImageView, url: String?)
{
    view.downloadImage(url, createPlaceholder(view.context))
}