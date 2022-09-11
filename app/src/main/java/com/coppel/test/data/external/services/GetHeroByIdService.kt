package com.coppel.test.data.external.services

import com.example.example.Hero
import com.coppel.test.data.external.configuration.ServiceConfiguration
import com.coppel.test.data.external.configuration.ServiceConfiguration.CONNECTION_ERROR
import com.coppel.test.data.external.configuration.ServiceConfiguration.NO_INTERNET
import com.coppel.test.data.external.configuration.ServiceListener
import com.coppel.test.domain.utils.network.NoConnectivityException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetHeroByIdService {

    suspend fun callService(id: Int, serviceListener: ServiceListener<String, Hero>) {
        withContext(Dispatchers.IO) {
            val call = ServiceConfiguration.webEndpoints.getHeroById(id.toString())

            call.enqueue(object : Callback<Hero> {
                override fun onResponse(call: Call<Hero>, response: Response<Hero>) {
                    if (response.isSuccessful && response.body() != null) {
                        serviceListener.onServiceSuccess(response.body()!!)
                    } else {
                        serviceListener.onServiceFail(CONNECTION_ERROR)
                    }
                }

                override fun onFailure(call: Call<Hero>, error: Throwable) {
                    when (error) {
                        is NoConnectivityException -> {
                            serviceListener.onServiceFail(NO_INTERNET)
                        }
                        else -> {
                            serviceListener.onServiceFail(CONNECTION_ERROR)
                        }
                    }
                }
            })

        }
    }

}