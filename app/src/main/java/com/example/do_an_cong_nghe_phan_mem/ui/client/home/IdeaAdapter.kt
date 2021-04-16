package com.example.do_an_cong_nghe_phan_mem.ui.client.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea

class IdeaAdapter(  private val onItemClick: (Idea) -> Unit) : RecyclerView.Adapter<IdeaAdapterViewHolder>() {

    private val ideas = mutableListOf<Idea>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdeaAdapterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_trending_idea, parent, false)
        return IdeaAdapterViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: IdeaAdapterViewHolder, position: Int) {
        holder.binData(ideas[position])
    }

    override fun getItemCount() = ideas.size

    fun updateString(string: String) {
        Log.e("xxx", string)
    }

    fun updateData(ideas: MutableList<Idea>) {
        ideas.let {
            this.ideas.clear()
            this.ideas.addAll(/*it.take(5)*/it)
            notifyDataSetChanged()
        }
    }
}