package com.pakt_games.myapplication.ui.moviehome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.pakt_games.myapplication.R
import com.pakt_games.myapplication.viewpager.MainViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var tabTitle = arrayOf("FİLMLER","FAVORİ FİLMLER")

        viewPager2.adapter = MainViewPagerAdapter(childFragmentManager , lifecycle)

        TabLayoutMediator(tabLayout,viewPager2) {
                tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

}