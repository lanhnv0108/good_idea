package com.example.do_an_cong_nghe_phan_mem.ui.client.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import com.example.do_an_cong_nghe_phan_mem.ui.client.createidea.CreateIdeaFragment
import com.example.do_an_cong_nghe_phan_mem.ui.client.detial.FragmentDetailIdea
import com.example.do_an_cong_nghe_phan_mem.ui.client.home.popular.IdeaPopularAdapter
import com.example.do_an_cong_nghe_phan_mem.ui.viewmodel.MainViewModel
import com.example.do_an_cong_nghe_phan_mem.utils.addFragment
import kotlinx.android.synthetic.main.fragment_idea.*

class IdeaFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val ideaAdapter by lazy {
        IdeaAdapter() {
            addFragment(FragmentDetailIdea.newInstance(it.id), R.id.containerLayout)
        }
    }
    private val ideaPopularAdapter by lazy {
        IdeaPopularAdapter() {
            addFragment(FragmentDetailIdea.newInstance(it.id), R.id.containerLayout)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_idea, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        evenFloatingActionButton()
        initView()
        initData()
    }

    private fun evenFloatingActionButton() {
        floating_action_button.setOnClickListener {
            addFragment(CreateIdeaFragment.newInstance(), R.id.containerLayout)
        }
    }

    private fun initView() {
        recyclerPopular.apply {
            setHasFixedSize(true)
            adapter = this@IdeaFragment.ideaAdapter
        }
        recyclerViewPopular.apply {
            setHasFixedSize(true)
            adapter = this@IdeaFragment.ideaPopularAdapter
        }
    }

    private fun initData() {
        viewModel =
            ViewModelProvider(
                activity!!,
                ViewModelProvider.AndroidViewModelFactory(activity!!.application)
            ).get(
                MainViewModel::class.java
            )
        viewModel.getAllIdea(1)
        viewModel.getAllIdea?.observe(this, {
            Log.e("xxx", it.toMutableList().toString())
            val s = it.toMutableList()
            ideaAdapter.updateData(s)
            ideaPopularAdapter.updateData(s)
        })
    }

    companion object {
        fun newInstance() = IdeaFragment()
    }
}