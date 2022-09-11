package com.coppel.test.presentation.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.example.Hero
import com.coppel.test.R
import com.coppel.test.databinding.FragmentHeroDetailBinding
import com.coppel.test.domain.viewmodels.fragments.HeroDetailViewModel
import com.coppel.test.domain.viewmodels.fragments.HeroesViewModel
import com.coppel.test.domain.viewmodels.fragments.factories.HeroesFactory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope

const val HERO = "hero"

class HeroDetailFragment : Fragment() {

    private lateinit var bind: FragmentHeroDetailBinding
    private lateinit var hero: Hero
    private lateinit var viewModel: HeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            hero = it.getParcelable(HERO)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bind = FragmentHeroDetailBinding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this)[HeroDetailViewModel::class.java]
    }

    private fun initObservers() {
        viewModel.hero.observe(requireActivity()) {
            with(bind) {
                tvName.text = it.name ?: "-"
                Picasso.get().load(it.image?.url).resize(240, 320).centerInside().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_image_search).into(ivHero)

                it.biography?.let {
                    dvFullName.setValue(it.fullName ?: "-")
                    dvAlterEgos.setValue(it.alterEgos ?: "-")
                    dvAliases.setValue(it.aliases.toString()) // TODO
                    dvBirth.setValue(it.placeOfBirth ?: "-")
                    dvFirstAppearance.setValue(it.firstAppearance ?: "-")
                    dvPublisher.setValue(it.publisher ?: "-")
                    dvAlignment.setValue(it.alignment ?: "-")
                }

                it.appearance?.let {
                    dvGender.setValue(it.gender ?: "-")
                    dvRace.setValue(it.race ?: "-")
                    dvHeight.setValue(it.height.toString()) // TODO
                    dvWeight.setValue(it.weight.toString()) // TODO
                    dvEyeColor.setValue(it.eyeColor ?: "-")
                    dvHairColor.setValue(it.hairColor ?: "-")
                }

                it.powerStats?.let {
                    dvIntelligence.setValue(it.intelligence ?: "-")
                    dvStrength.setValue(it.strength ?: "-")
                    dvSpeed.setValue(it.speed ?: "-")
                    dvDurability.setValue(it.durability ?: "-")
                    dvPower.setValue(it.power ?: "-")
                    dvCombat.setValue(it.combat ?: "-")
                }

                it.work?.let {
                    dvOccupation.setValue(it.occupation ?: "-")
                    dvBase.setValue(it.base ?: "-")
                }

                it.connections?.let {
                    dvAffiliation.setValue(it.groupAffiliation ?: "-")
                    dvRelatives.setValue(it.relatives ?: "-")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.setHero(hero)
    }
}