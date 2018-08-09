package com.mbobiosio.wcteam.helper

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class DataBaseHelper(private val mContext: Context) : SQLiteOpenHelper(mContext, DB_NAME, null, 2) {
    private var mDataBase: SQLiteDatabase? = null

    init {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = mContext.applicationInfo.dataDir + "/databases/"
        } else {
            DB_PATH = "/data/data/" + mContext.packageName + "/databases/"
        }
    }// 1? Its database Version

    @Throws(IOException::class)
    fun createDataBase() {
        //If the database does not exist, copy it from the assets.

        val mDataBaseExist = checkDataBase()
        if (!mDataBaseExist) {
            this.readableDatabase
            this.close()
            try {
                //Copy the database from assests
                copyDataBase()
                Log.e(TAG, "createDatabase database created")
            } catch (mIOException: IOException) {
                throw Error("ErrorCopyingDataBase")
            }

        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private fun checkDataBase(): Boolean {
        val dbFile = File(DB_PATH + DB_NAME)
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists()
    }

    //Copy the database from assets
    @Throws(IOException::class)
    private fun copyDataBase() {
        val mInput = mContext.assets.open(DB_NAME)
        val outFileName = DB_PATH + DB_NAME
        val mOutput = FileOutputStream(outFileName)
        val mBuffer = ByteArray(1024)

//        var mLength: Int
//        while ((mLength = mInput.read(mBuffer)) > 0) {
//            mOutput.write(mBuffer, 0, mLength)
//        }

        var mLength = mInput.read(mBuffer)
        while (mLength > 0) {
            mOutput.write(mBuffer, 0, mLength)
            mLength = mInput.read(mBuffer)
        }
        mOutput.flush()
        mOutput.close()
        mInput.close()
    }

    //Open the database, so we can query it
    @Throws(SQLException::class)
    fun openDataBase(): Boolean {
        val mPath = DB_PATH + DB_NAME
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY)
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null
    }

    @Synchronized
    override fun close() {
        if (mDataBase != null)
            mDataBase!!.close()
        super.close()
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {

    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        mDataBase?.execSQL("DROP TABLE IF EXISTS $DB_PATH")
        mDataBase?.execSQL("PRAGMA encoding = UTF;")
        onCreate(sqLiteDatabase)
        Log.w(DataBaseHelper::class.java.name, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data")
        try {
            copyDataBase()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        Log.w(DataBaseHelper::class.java.name, "Data base is upgraded  ")
    }

    companion object {

        private val TAG = "DataBaseHelper" // Tag just for the LogCat window
        //destination path (location) of our database on device
        private var DB_PATH = ""
        private val DB_NAME = "players.db"// Database name
    }
}