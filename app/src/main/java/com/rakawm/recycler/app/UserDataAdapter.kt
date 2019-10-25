package com.rakawm.recycler.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserDataAdapter : RecyclerView.Adapter<UserDataViewHolder>() {
    private var data: MutableList<UserData> = mutableListOf()

    fun setData(data: MutableList<UserData>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return UserDataViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        holder.bindData(
            data[position]
        )
    }
}