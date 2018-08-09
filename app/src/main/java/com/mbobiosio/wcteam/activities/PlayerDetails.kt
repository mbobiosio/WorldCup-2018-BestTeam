package com.mbobiosio.wcteam.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.mbobiosio.wcteam.R
import com.mbobiosio.wcteam.model.Player
import kotlinx.android.synthetic.main.activity_player_details.*
import kotlinx.android.synthetic.main.player_detail_content.*
import org.parceler.Parcels

/**
 * Created by Mbuodile Obiosio on 7/19/18
 * cazewonder@gmail.com
 */

class PlayerDetails : BaseActivity() {

    lateinit var mPlayer: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_details)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mPlayer = Parcels.unwrap(intent.getParcelableExtra("details"))

        val bundle = intent.extras
        if (bundle != null) {
            collapsingToolbar.title = mPlayer.name
            nationality.text = mPlayer.nationality
            club.text = mPlayer.club
            position.text = mPlayer.role
            profile.text = mPlayer.profile
            Glide.with(this).load(mPlayer.aviThumb).into(avi)
            Glide.with(this).load(mPlayer.avi).into(full_image)
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
