package com.example.do_an_cong_nghe_phan_mem.ui.client.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import kotlinx.android.synthetic.main.item_trending_idea.view.*

class IdeaAdapterViewHolder(
    itemView: View,
    private val onItemClick: (Idea) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun binData(idea: Idea) {
        itemView.apply {
            textViewNameIdeaItem.text = idea.name
            setOnClickListener {
                onItemClick(idea)
            }
        }
    }
}
