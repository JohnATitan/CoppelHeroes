package com.coppel.test

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.coppel.test.domain.utils.network.NetworkUtils

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkUtils.connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    }
}