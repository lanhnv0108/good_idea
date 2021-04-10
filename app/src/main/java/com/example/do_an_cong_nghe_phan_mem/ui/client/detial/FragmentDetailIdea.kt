package com.example.do_an_cong_nghe_phan_mem.ui.client.detial

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea

class FragmentDetailIdea : Fragment() {

    private var idIdea: Int? = null
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idIdea = it.getInt(ARG_ID_MOVIE_DETAIL)
        }
        Log.e("xxx", idIdea.toString())
        viewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory(activity!!.application)
            ).get(
                DetailViewModel::class.java
            )
        viewModel.getAllIdea(idIdea)
        viewModel.getIdea?.observe(this, {
//            Log.e("xxx", it.toString())
            initDetail(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detial_idea_client, container, false)
    }

    fun initDetail(idea: Idea) {
        Log.e("xxx" , "Idea $idea")
    }

    companion object {
        private const val ARG_ID_MOVIE_DETAIL = "ARG_ID_IDEA_DETAIL"

        fun newInstance(id: Int) = FragmentDetailIdea().apply {
            arguments = bundleOf(ARG_ID_MOVIE_DETAIL to id)
        }
    }

}
