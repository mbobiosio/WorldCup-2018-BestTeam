package com.mbobiosio.wcteam.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mbobiosio.wcteam.R
import com.mbobiosio.wcteam.activities.PlayerDetails
import com.mbobiosio.wcteam.model.Player
import org.parceler.Parcels
import java.util.*


class MyRecyclerViewAdapter(private val mDataset: ArrayList<Player>) : RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder>() {
    private lateinit var ctx: Context

    class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var player: TextView
        internal var nationality: TextView
        internal var role: TextView
        internal var avi: ImageView
        internal var card: CardView

        init {
            player = itemView.findViewById(R.id.player)
            nationality = itemView.findViewById(R.id.nationality)
            role = itemView.findViewById(R.id.role)
            avi = itemView.findViewById(R.id.avi)
            card = itemView.findViewById(R.id.item_card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.players_item_row, parent, false)

        ctx = parent.context

        return DataObjectHolder(view)
    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {
        val model = mDataset[position]
        holder.player.text = model.name
        holder.nationality.text = model.nationality
        holder.role.text = model.role
        Glide.with(ctx).load(model.aviThumb).into(holder.avi)

        holder.card.setOnClickListener { _ ->
            val intent = Intent(ctx, PlayerDetails::class.java)
            intent.putExtra("details", Parcels.wrap(mDataset[position]))
            ctx.startActivity(intent)
        }
    }

    fun addItem(dataObj: Player, index: Int) {
        mDataset.add(index, dataObj)
        notifyItemInserted(index)
    }

    fun deleteItem(index: Int) {
        mDataset.removeAt(index)
        notifyItemRemoved(index)
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}