package com.example.do_an_cong_nghe_phan_mem.ui.admin.approve

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.ui.admin.adapter.IdeaPopularAdminAdapter
import com.example.do_an_cong_nghe_phan_mem.ui.admin.detail.FragmentDetailAdminIdea
import com.example.do_an_cong_nghe_phan_mem.ui.client.detial.FragmentDetailIdea
import com.example.do_an_cong_nghe_phan_mem.ui.viewmodel.MainViewModel
import com.example.do_an_cong_nghe_phan_mem.utils.addFragment
import kotlinx.android.synthetic.main.fragment_approve_admin.*
import kotlinx.android.synthetic.main.fragment_idea.*

class ApproveFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private val adapterApprove by lazy {
        IdeaPopularAdminAdapter() {
            addFragment(FragmentDetailAdminIdea.newInstance(it.id), R.id.containerLayout)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_approve_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
        refreshData()
    }

    private fun initData() {
        viewModel =
            ViewModelProvider(
                activity!!,
                ViewModelProvider.AndroidViewModelFactory(activity!!.application)
            ).get(
                MainViewModel::class.java
            )
        viewModel.getAllIdea(0)
        viewModel.getAllIdea?.observe(this, {
            val s = it.toMutableList()
            adapterApprove.updateData(s)
        })
    }

    private fun refreshData() {
        swipeRefreshDataAdmin.setOnRefreshListener {
            initData()
            initView()
        }
    }

    private fun initView() {
        recyclerViewApprove.apply {
            setHasFixedSize(true)
            adapter = this@ApproveFragment.adapterApprove
        }
        swipeRefreshDataAdmin.isRefreshing = false
    }


    companion object {
        fun newInstance() = ApproveFragment()
    }
}

