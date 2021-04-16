package com.example.do_an_cong_nghe_phan_mem.ui.admin.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import kotlinx.android.synthetic.main.fragment_detail_idea_admin.*

class FragmentDetailAdminIdea : Fragment() {

    private var idIdea: Int? = null
    private lateinit var viewModel: DetailAdminViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idIdea = it.getInt(ARG_ID_MOVIE_DETAIL)
        }
        viewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory(activity!!.application)
            ).get(
                DetailAdminViewModel::class.java
            )
        viewModel.getAllIdea(idIdea)
        viewModel.getIdea?.observe(this, {
            initDetail(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_idea_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventButton()
    }

    private fun initDetail(idea: Idea) {
        textViewCreateIdeaAdmin.text = idea.name
        textViewDescriptionContentIdeaDetailAdmin.text = idea.description
        textViewAddressDetailAdmin.text = idea.address
        textViewContentStartAdmin.text = idea.timeStart
        textViewContentStopAdmin.text = idea.timeEnd
    }

    private fun eventButton() {
        buttonApprove.setOnClickListener {
            viewModel.updateApprove(idIdea)
            fragmentManager?.popBackStack()
            Toast.makeText(context, "Duyệt thành công !!!", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val ARG_ID_MOVIE_DETAIL = "ARG_ID_IDEA_DETAIL"

        fun newInstance(id: Int) = FragmentDetailAdminIdea().apply {
            arguments = bundleOf(ARG_ID_MOVIE_DETAIL to id)
        }
    }

}
