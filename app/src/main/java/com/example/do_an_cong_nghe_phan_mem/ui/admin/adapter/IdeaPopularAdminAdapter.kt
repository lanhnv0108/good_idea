package com.example.do_an_cong_nghe_phan_mem.ui.admin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea

class IdeaPopularAdminAdapter(private val onItemClick: (Idea) -> Unit) :
    RecyclerView.Adapter<IdeaPopularAdminAdapterViewHolder>() {

    private val ideas = mutableListOf<Idea>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IdeaPopularAdminAdapterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_approve_admin, parent, false)
        return IdeaPopularAdminAdapterViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: IdeaPopularAdminAdapterViewHolder, position: Int) {
        holder.binData(ideas[position])
    }

    override fun getItemCount() = ideas.size

    fun updateData(ideas: MutableList<Idea>) {
        ideas.let {
            this.ideas.clear()
            this.ideas.addAll(it)
            notifyDataSetChanged()
        }
    }
}