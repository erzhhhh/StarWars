package com.example.erzhena.starwars.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.erzhena.starwars.R
import com.example.erzhena.starwars.models.ConcreteFilm
import kotlinx.android.synthetic.main.film_item.view.newsTitle

class StarWarsFilmsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = ArrayList<ConcreteFilm>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StarWarsItemViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<ConcreteFilm>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pm = items[position]
        (holder as StarWarsItemViewHolder).bind(pm)

    }

    private class StarWarsItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.film_item, parent, false)) {

        fun bind(pm: ConcreteFilm) {
            with(itemView) {
                newsTitle.text = pm.title
            }
        }

    }
}