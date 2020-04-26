package com.dede.coroutinexretrofitexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sport_item.view.*

class SportAdapter : RecyclerView.Adapter<SportAdapter.SportViewHolder>() {
    private var data = mutableListOf<SportResponse.SportData>()

    fun setData(data : List<SportResponse.SportData>?){
        data?.let { this.data.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SportAdapter.SportViewHolder =
        SportViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sport_item, parent, false)
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SportAdapter.SportViewHolder, position: Int) {
        holder.bindItem(data[position])
    }

    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: SportResponse.SportData) {
            itemView.textSportName.text = item.sportName
        }
    }
}