package com.coppel.test.data.external.interceptor

import com.coppel.test.domain.utils.network.NetworkUtils
import com.coppel.test.domain.utils.network.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class NetworkConnectionInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtils.validateNetwork()) {
            throw NoConnectivityException()
        }

        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}