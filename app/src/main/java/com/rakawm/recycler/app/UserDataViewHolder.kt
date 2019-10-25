package com.rakawm.recycler.app

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_data.view.*

class UserDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                if (itemView.item_hidden_container.isVisible) {
                    itemView.item_hidden_container.visibility = View.GONE
                    itemView.item_arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_24px)
                } else {
                    itemView.item_hidden_container.visibility = View.VISIBLE
                    itemView.item_arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_24px)
                }
            }
        }
    }

    fun bindData(data: UserData) {
        itemView.item_name.text = data.name
        itemView.item_university.text = data.university
        itemView.item_date_of_birth.text = data.dateOfBirthFormatted
        itemView.item_short_bio.text = data.shortBio
    }
}