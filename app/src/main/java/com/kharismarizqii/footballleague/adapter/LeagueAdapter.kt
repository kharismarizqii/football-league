package com.kharismarizqii.footballleague.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kharismarizqii.footballleague.R
import com.kharismarizqii.footballleague.model.League
import com.kharismarizqii.footballleague.ui.LeagueUI
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class LeagueAdapter (
    private val items: List<League>,
    private val listener: (League)-> Unit
    ) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>(){


    class LeagueViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val logo: ImageView = view.find(R.id.league_logo)
        private val name: TextView = view.find(R.id.league_name)

        fun bind(items: League, listener: (League) -> Unit){
            name.text = items.name
            Picasso.get().load(items.logo!!).resize(60,60).into(logo)


            itemView.setOnClickListener{
                listener(items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val view = LeagueUI().createView(
            AnkoContext.Companion.create(
                parent.context,
                parent
            )
        )

        return LeagueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

}