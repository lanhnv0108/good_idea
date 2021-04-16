package com.example.do_an_cong_nghe_phan_mem.ui.admin.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import kotlinx.android.synthetic.main.item_approve_admin.view.*
import kotlinx.android.synthetic.main.item_popular_idea.view.*
import kotlinx.android.synthetic.main.item_popular_idea.view.textViewTittlePopular

class IdeaPopularAdminAdapterViewHolder(
    itemView: View,
    private val onItemClick: (Idea) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun binData(idea: Idea) {
        itemView.apply {
            textViewTittleApprove.text = idea.name
            setOnClickListener {
                onItemClick(idea)
            }
        }
    }
}
