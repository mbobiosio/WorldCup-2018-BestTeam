package com.mbobiosio.wcteam.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.mbobiosio.wcteam.R
import com.rohitarya.glide.facedetection.transformation.core.GlideFaceDetector
import kotlinx.android.synthetic.main.about_me_activity.*
import kotlinx.android.synthetic.main.about_me_content.*

/**
 * Created by Mbuodile Obiosio on 7/19/18
 * cazewonder@gmail.com
 */
class AboutMe : BaseActivity() {

    val fbUrl = Uri.parse("https://facebook.com/cazeewonder")
    val twitUrl = Uri.parse("https://twitter.com/cazewonder")
    val linkedinUrl = Uri.parse("https://www.linkedin.com/in/mb-obiosio/")
    val gitUrl = Uri.parse("https://github.com/mbobiosio")
    val AVI_URL = "https://dttslimited.com/imgup/mb.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me_activity)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(this)
                .load(AVI_URL)
                .into(full_image)

        collapsingToolbar.title = getString(R.string.developer_name)

        facebook.setOnClickListener {
            val facebook = Intent(Intent.ACTION_VIEW, fbUrl)
            startActivity(facebook)
        }
        twitter.setOnClickListener {
            val twitter = Intent(Intent.ACTION_VIEW, twitUrl)
            startActivity(twitter)
        }
        linkedin.setOnClickListener {
            val linkedIn = Intent(Intent.ACTION_VIEW, linkedinUrl)
            startActivity(linkedIn)
        }
        github.setOnClickListener {
            val git = Intent(Intent.ACTION_VIEW, gitUrl)
            startActivity(git)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
