package com.pakt_games.myapplication

import android.app.Application
import com.pakt_games.myapplication.network.ServiceConnector

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()
    }
}