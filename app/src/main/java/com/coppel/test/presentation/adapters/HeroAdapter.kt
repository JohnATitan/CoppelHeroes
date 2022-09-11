package com.coppel.test.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Hero
import com.coppel.test.R
import com.coppel.test.presentation.adapters.listeners.HeroAdapterListener
import com.squareup.picasso.Picasso

class HeroAdapter(private val listener: HeroAdapterListener) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    private val heroes = arrayListOf<Hero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_hero, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    fun setHero(hero: Hero?) {
        hero?.let {
            heroes.add(hero)
            notifyItemInserted(heroes.size - 1)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val ivHero = view.findViewById<ImageView>(R.id.ivHero)

        fun bind(hero: Hero) {
            tvName.text = hero.name
            Picasso.get().load(hero.image?.url).resize(240, 320).centerInside().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_image_search).into(ivHero)

            itemView.setOnClickListener {
                listener.onHeroSelected(hero)
            }
        }
    }
}