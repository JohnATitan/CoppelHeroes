package com.coppel.test.domain.utils.network

import android.net.ConnectivityManager

object NetworkUtils {

    var connectivityManager: ConnectivityManager? = null

    fun validateNetwork(): Boolean {
        return (isConnectedMobile() || isConnectedWifi()) && isNetAvailable()
    }

    private fun isNetAvailable(): Boolean {
        val networkInfo = if (connectivityManager != null) connectivityManager!!.activeNetworkInfo else null
        return networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected
    }

    private fun isConnectedWifi(): Boolean {
        val networkInfo = if (connectivityManager != null) connectivityManager!!.activeNetworkInfo else null
        return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_WIFI
    }

    private fun isConnectedMobile(): Boolean {
        val networkInfo = if (connectivityManager != null) connectivityManager!!.activeNetworkInfo else null
        return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_MOBILE
    }

}