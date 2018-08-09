package com.mbobiosio.wcteam

import android.app.Application

import com.mbobiosio.wcteam.database.DataAdapter

/**
 * Created by podo on 4/2/16.
 */
class WCApp : Application() {
    lateinit var mDbHelper: DataAdapter
    override fun onCreate() {
        super.onCreate()
        mDbHelper = DataAdapter.getInstance(applicationContext)
        mDbHelper.createDatabase()
        mDbHelper.open()
    }
}

