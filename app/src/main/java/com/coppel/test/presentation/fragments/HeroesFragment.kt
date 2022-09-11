package com.coppel.test.presentation.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coppel.test.R
import com.coppel.test.databinding.FragmentHeroesBinding
import com.coppel.test.domain.utils.ViewUtils
import com.coppel.test.domain.viewmodels.fragments.HeroesViewModel
import com.coppel.test.domain.viewmodels.fragments.factories.HeroesFactory
import com.coppel.test.presentation.adapters.HeroAdapter
import com.coppel.test.presentation.adapters.listeners.HeroAdapterListener
import com.coppel.test.presentation.fragments.views.HeroesView
import com.example.example.Hero

class HeroesFragment : Fragment(), HeroesView, HeroAdapterListener {

    private lateinit var bind: FragmentHeroesBinding
    private lateinit var progressDialog: AlertDialog
    private val adapter = HeroAdapter(this)
    private lateinit var viewModel: HeroesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bind = FragmentHeroesBinding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        initAdapters()
        initListeners()
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this, HeroesFactory(this))[HeroesViewModel::class.java]
        progressDialog = ViewUtils.buildProgressDialog(layoutInflater, requireContext())
    }

    private fun initObservers() {
        viewModel.progress.observe(requireActivity()) { visibility ->
            if (visibility) progressDialog.show() else progressDialog.dismiss()
        }
    }

    private fun initAdapters() {
        bind.rvHeroes.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        bind.rvHeroes.adapter = adapter
    }

    private fun initListeners() {
        bind.rvHeroes.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    progressDialog.show()
                    viewModel.getHeroes()
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        if (adapter.itemCount == 0) {
            progressDialog.show()
            viewModel.getHeroes()
        }
    }

    override fun onGetHero(hero: Hero) {
        adapter.setHero(hero)
        bind.rvHeroes.scrollToPosition(adapter.itemCount - 1)
    }

    override fun showError(error: String) {
        progressDialog.dismiss()
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun onHeroSelected(hero: Hero) {
        val bundle = Bundle()
        bundle.putParcelable(HERO, hero)
        findNavController().navigate(R.id.action_heroesFragment_to_heroDetailFragment, bundle)
    }
}