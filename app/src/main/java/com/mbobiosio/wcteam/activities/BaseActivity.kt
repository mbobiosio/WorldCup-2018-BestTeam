package com.mbobiosio.wcteam.activities

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.mbobiosio.wcteam.R

/**
 * Created by Mbuodile Obiosio on 7/19/18
 * cazewonder@gmail.com
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
    }


    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down)
    }
}
