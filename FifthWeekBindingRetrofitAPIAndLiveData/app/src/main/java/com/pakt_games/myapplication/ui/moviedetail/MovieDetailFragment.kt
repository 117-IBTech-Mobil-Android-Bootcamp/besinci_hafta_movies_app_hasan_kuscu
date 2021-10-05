package com.pakt_games.myapplication.ui.moviedetail

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pakt_games.myapplication.R
import com.pakt_games.myapplication.base.BaseFragment
import com.pakt_games.myapplication.databinding.FragmentMovieDetailBinding
import com.pakt_games.myapplication.ui.movielist.model.FavoriteMovies
import com.pakt_games.myapplication.ui.movielist.model.Movie
import com.pakt_games.myapplication.util.showToast
import kotlinx.android.synthetic.main.fragment_movie_detail.*


class MovieDetailFragment() : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {
    override var viewModel: MovieDetailViewModel?= null
    override fun getLayoutID(): Int = R.layout.fragment_movie_detail
    private var movieId = 0
    private var movieTitle ="TEST"

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }

    fun getSingleMovieData()
    {
        arguments?.let {
            movieId = MovieDetailFragmentArgs.fromBundle(it).movieId
            movieTitle =MovieDetailFragmentArgs.fromBundle(it).movieTitle
        }
        viewModel!!.getRoomData(movieId)
    }
    override fun observeLiveData() {
       getSingleMovieData()
        viewModel?.movieLiveData?.observe(viewLifecycleOwner, Observer { movie->
            movie?.let {
                dataBinding.model=it
            }
        })
        dataBinding.imageViewMovieDetailFavoriteHeart.setOnClickListener {
           dataBinding.imageViewMovieDetailFavoriteHeart.setImageResource(R.drawable.black_heart)
            val sharedPreferences = this.requireActivity().getSharedPreferences("SP", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply{
                putString("favorMovie", movieTitle)
            }.apply()
            showToast("Başarı ile favorilere kayıt edildi.")
        }
    }
}