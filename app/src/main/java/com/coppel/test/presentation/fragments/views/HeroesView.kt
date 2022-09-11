package com.coppel.test.presentation.fragments.views

import com.example.example.Hero

interface HeroesView {
    fun onGetHero(hero: Hero)
    fun showError(error: String)
}