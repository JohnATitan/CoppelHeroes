package com.coppel.test.data.external.configuration

import com.google.gson.GsonBuilder
import com.coppel.test.data.external.interceptor.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceConfiguration {

    const val NO_INTERNET = "Sin conexión a internet"
    const val CONNECTION_ERROR = "Ocurrió un error en la consulta"

    private val retrofit: Retrofit by lazy {
        val logInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder().apply {
            readTimeout(120, TimeUnit.SECONDS)
            writeTimeout(120, TimeUnit.SECONDS)
            connectTimeout(120, TimeUnit.SECONDS)
            addInterceptor(NetworkConnectionInterceptor())
            addInterceptor(logInterceptor)
        }.build()

        Retrofit.Builder().apply {
            baseUrl("https://www.superheroapi.com/api/103128529216665/")

            addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            client(httpClient)
        }.build()
    }

    val webEndpoints: WebEndpoints by lazy {
        retrofit.create(WebEndpoints::class.java)
    }
}