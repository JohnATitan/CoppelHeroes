package com.coppel.test.domain.viewmodels.fragments.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coppel.test.domain.viewmodels.fragments.HeroesViewModel
import com.coppel.test.presentation.fragments.views.HeroesView

class HeroesFactory(private val listener: HeroesView) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HeroesViewModel(listener) as T
}