package com.example.do_an_cong_nghe_phan_mem.ui.client.home.popular

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea

class IdeaPopularAdapter(private val onItemClick: (Idea) -> Unit) :
    RecyclerView.Adapter<IdeaPopularAdapterViewHolder>() {

    private val ideas = mutableListOf<Idea>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IdeaPopularAdapterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular_idea, parent, false)
        return IdeaPopularAdapterViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: IdeaPopularAdapterViewHolder, position: Int) {
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