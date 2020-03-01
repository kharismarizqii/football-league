package com.kharismarizqii.footballleague

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.footballleague.adapter.LeagueAdapter
import com.kharismarizqii.footballleague.model.League
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    private var items: MutableList<League> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLeague()

        verticalLayout {
            recyclerView {
                lparams(height = matchParent, width = matchParent)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = LeagueAdapter(
                    items
                ) {
                    itemClicked(it)
                }
            }
        }
    }

    private fun itemClicked(items: League){
        startActivity<DetailLeagueActivity>(
            DetailLeagueActivity.NAME to items.name,
            DetailLeagueActivity.DESCRIPTION to items.desc,
            DetailLeagueActivity.LOGO to items.logo
        )

    }

    private fun loadLeague() {
        val name = resources.getStringArray(R.array.league_name)
        val description = resources.getStringArray(R.array.league_description)
        val badge = resources.obtainTypedArray(R.array.league_logo)

        items.clear()
        for (i in name.indices){
            items.add(
                League(name[i], badge.getResourceId(i,0), description[i])
            )
        }

        badge.recycle()
    }
}
