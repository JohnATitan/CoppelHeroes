package com.coppel.test.data.external.configuration

import com.example.example.Hero
import retrofit2.Call
import retrofit2.http.*

interface WebEndpoints {
    @GET("{id}")
    fun getHeroById(@Path("id") id: String): Call<Hero>
}