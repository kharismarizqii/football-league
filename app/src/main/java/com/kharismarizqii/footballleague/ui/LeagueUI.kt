package com.kharismarizqii.footballleague.ui

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kharismarizqii.footballleague.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class LeagueUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            cardView{
                lparams(height= wrapContent, width = matchParent){
                    margin = dip(8)
                }

                verticalLayout{
                    lparams(height = wrapContent, width = matchParent)
                    orientation = LinearLayout.HORIZONTAL
                    padding = dip(16)

                    imageView{
                        id = R.id.league_logo
                    }.lparams{
                        margin = dip(8)
                    }

                    textView {
                        id = R.id.league_name
                        textSize = 16f
                    }.lparams{
                        margin = dip(8)
                    }



                }
            }



        }
    }

}