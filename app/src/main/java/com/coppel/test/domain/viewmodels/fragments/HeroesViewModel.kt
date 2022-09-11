package com.coppel.test.domain.viewmodels.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coppel.test.data.external.configuration.ServiceConfiguration.NO_INTERNET
import com.example.example.Hero
import com.coppel.test.data.external.services.GetHeroByIdService
import com.coppel.test.data.external.configuration.ServiceListener
import com.coppel.test.presentation.fragments.views.HeroesView
import kotlinx.coroutines.launch

const val TOTAL_HEROES = 731
const val MAX_HEROES_REQUESTED = 10

class HeroesViewModel(private var listener: HeroesView) : ViewModel() {
    private val mainService = GetHeroByIdService()
    private var idHero = 1
    private var indexHero = 0
    private val serviceListener = object : ServiceListener<String, Hero> {
        override fun onServiceSuccess(result: Hero) {
            listener.onGetHero(result)
            indexHero++
            getHeroes()
        }

        override fun onServiceFail(error: String) {
            listener.showError(error)
        }
    }

    val progress = MutableLiveData<Boolean>()

    fun getHeroes() {
        if (indexHero < MAX_HEROES_REQUESTED && idHero <= TOTAL_HEROES) {
            callServiceHero(idHero++)
        } else {
            indexHero = 0
            progress.postValue(false)
        }
    }

    private fun callServiceHero(id: Int) {
        viewModelScope.launch {
            mainService.callService(id, serviceListener)
        }
    }
}