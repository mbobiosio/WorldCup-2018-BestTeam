package com.mbobiosio.wcteam

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.mbobiosio.wcteam.activities.AboutMe
import com.mbobiosio.wcteam.activities.BaseActivity
import com.mbobiosio.wcteam.adapter.MyRecyclerViewAdapter
import com.mbobiosio.wcteam.database.DataAdapter
import com.mbobiosio.wcteam.model.Player
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    lateinit var mDbHelper: DataAdapter

    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var players: ArrayList<Player>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDbHelper = DataAdapter.getInstance(applicationContext)

        my_recycler_view.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        my_recycler_view.layoutManager = mLayoutManager
        players = mDbHelper.players

        mAdapter = MyRecyclerViewAdapter(players!!)
        my_recycler_view.adapter = mAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.about) {
            val intent = Intent(this, AboutMe::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
