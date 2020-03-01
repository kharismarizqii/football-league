package com.kharismarizqii.footballleague

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailLeagueActivity : AppCompatActivity() {

    private var name: String? = ""
    private var desc: String? = ""
    private var badge: Int = 0

    private lateinit var tvName: TextView
    private lateinit var ivBadge: ImageView
    private lateinit var tvDesc: TextView

    companion object {
        const val NAME = "name"
        const val DESCRIPTION = "desc"
        const val LOGO = "logo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        badge = intent.getIntExtra(LOGO, 0)
        desc = intent.getStringExtra(DESCRIPTION)
        name = intent.getStringExtra(NAME)

        scrollView {
            lparams(width = matchParent, height = matchParent)
            verticalLayout {
                padding = dip(16)

                ivBadge = imageView().lparams(width = dip(220), height = dip(220)) {
                    gravity = Gravity.CENTER
                }
                tvName = textView {
                    textSize = 22f
                    typeface = Typeface.DEFAULT_BOLD
                }.lparams(width = wrapContent) {
                    gravity = Gravity.CENTER
                    topMargin = dip(16)
                }
                tvDesc = textView {
                    textSize = 14f
                }.lparams(width = wrapContent) {
                    margin = dip(16)
                    textAlignment = View.TEXT_ALIGNMENT_INHERIT
                }
            }
        }

        Picasso.get().load(badge).into(ivBadge)
        tvDesc.text = desc
        tvName.text = name
    }
}

