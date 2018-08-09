package com.mbobiosio.wcteam.database

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.mbobiosio.wcteam.helper.DataBaseHelper
import com.mbobiosio.wcteam.model.Player
import java.io.IOException
import java.util.*

class DataAdapter private constructor(private val mContext: Context) {
    private var mDb: SQLiteDatabase? = null
    private val mDbHelper: DataBaseHelper = DataBaseHelper(mContext)

    val players: ArrayList<Player>
        get() {

            val result = ArrayList<Player>()
            val sql = "SELECT * FROM \"players\""
            val cursor = mDb!!.rawQuery(sql, null)
            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    result.add(Player(
                            cursor.getInt(cursor.getColumnIndex(PLAYER_ID)),
                            cursor.getString(cursor.getColumnIndex(PLAYER_NAME)),
                            cursor.getString(cursor.getColumnIndex(PLAYER_NATIONALITY)),
                            cursor.getString(cursor.getColumnIndex(PLAYER_ROLE)),
                            cursor.getString(cursor.getColumnIndex(PLAYER_CLUB)),
                            cursor.getString(cursor.getColumnIndex(PLAYER_PROFILE)),
                            cursor.getString(cursor.getColumnIndex(PLAYER_IMAGE)),
                            cursor.getString(cursor.getColumnIndex(PLAYER_IMAGE_THUMBNAIL))
                    ))
                }


            }
            return result
        }

    @Throws(SQLException::class)
    fun createDatabase(): DataAdapter {
        try {
            mDbHelper.createDataBase()
        } catch (mIOException: IOException) {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase")
            throw Error("UnableToCreateDatabase")
        }

        return this
    }

    @Throws(SQLException::class)
    fun open(): DataAdapter {
        try {
            mDbHelper.openDataBase()
            mDbHelper.close()
            mDb = mDbHelper.readableDatabase
        } catch (mSQLException: SQLException) {
            Log.e(TAG, "open >>" + mSQLException.toString())
            throw mSQLException
        }

        return this
    }

    fun close() {
        mDbHelper.close()
    }

    companion object {
        protected val TAG = "DataAdapter"
        internal val PLAYER_ID = "id"
        internal val PLAYER_NAME = "name"
        internal val PLAYER_NATIONALITY = "nationality"
        internal val PLAYER_ROLE = "role"
        internal val PLAYER_CLUB = "club"
        internal val PLAYER_PROFILE = "profile"
        internal val PLAYER_IMAGE = "image"
        internal val PLAYER_IMAGE_THUMBNAIL = "imageThumb"

        private var sInstance: DataAdapter? = null

        @Synchronized
        fun getInstance(context: Context): DataAdapter {

            if (sInstance == null) {
                sInstance = DataAdapter(context.applicationContext)
            }
            return sInstance as DataAdapter
        }
    }
}