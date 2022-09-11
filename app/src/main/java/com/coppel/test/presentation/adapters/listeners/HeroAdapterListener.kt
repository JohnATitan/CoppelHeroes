package com.coppel.test.presentation.adapters.listeners

import android.view.View
import android.widget.ImageView
import com.example.example.Hero

interface HeroAdapterListener {
    fun onHeroSelected(hero: Hero)
}