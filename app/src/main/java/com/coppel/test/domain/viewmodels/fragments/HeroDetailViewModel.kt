package com.coppel.test.domain.viewmodels.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Hero
import kotlinx.coroutines.launch

class HeroDetailViewModel : ViewModel() {
    val hero = MutableLiveData<Hero>()

    fun setHero(hero: Hero) {
        viewModelScope.launch {
            this@HeroDetailViewModel.hero.postValue(hero)
        }
    }
}