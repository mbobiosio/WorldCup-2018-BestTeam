package com.mbobiosio.wcteam.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.mbobiosio.wcteam.R
import com.mbobiosio.wcteam.model.Player
import kotlinx.android.synthetic.main.activity_car_details.*
import org.parceler.Parcels

class CarDetailsActivity : AppCompatActivity() {

    lateinit var mPlayer: Player

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mPlayer = Parcels.unwrap(intent.getParcelableExtra("details"))

        val bundle = getIntent().extras
        if (bundle != null) {
            tv_model.text = mPlayer.name
            /*tv_manufacturer.text = "Manufacturer: ${mCar.manufacturer}"
            tv_speed.text = "Max Speed: ${mCar.speed}"
            tv_acceleration.text = "Acceleration from 0-100 in ${mCar.acceleration} Seconds"
            tv_engineSize!!.text = "Engine Size: ${mCar.acceleration} L"*/
            Glide.with(this).load(mPlayer.avi).into(car_image)
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
