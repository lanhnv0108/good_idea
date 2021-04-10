package com.example.do_an_cong_nghe_phan_mem.ui.client.createidea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.data.model.Idea
import com.example.do_an_cong_nghe_phan_mem.ui.viewmodel.MainViewModel
import com.example.do_an_cong_nghe_phan_mem.utils.removeFragment
import kotlinx.android.synthetic.main.fragment_createidea.*

class CreateIdeaFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_createidea, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventCreateIdea()
        evenCancelCreateIdea()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProvider(
                activity!!,
                ViewModelProvider.AndroidViewModelFactory(activity!!.application)
            ).get(
                MainViewModel::class.java
            )
        viewModel.getAllIdea?.observe(activity!!, {
            Toast.makeText(context, "gduagad", Toast.LENGTH_LONG).show()
        })
    }

    private fun eventCreateIdea() {
        buttonCreateIdea.setOnClickListener {
            val nameIdea = editTextNameIdea.text.toString()
            val descriptionIdea = editTextDescriptionIdea.text.toString()
            val addressIdea = editTextAddress.text.toString()
            val amount = editTextCount.text.toString().toInt()
            val timeStart = editTextTimeStartTime.text.toString()
            val timeStop = editTextTimeTimeTop.text.toString()
            Toast.makeText(context, "hihihi", Toast.LENGTH_LONG).show()
            /*            add idea to ROOM
             */
            viewModel.createIdea(
                Idea(
                    0,
                    nameIdea,
                    descriptionIdea,
                    addressIdea,
                    amount,
                    timeStart,
                    timeStop
                )
            )
            removeFragment(this)
        }
    }

    private fun evenCancelCreateIdea() {
        buttonCancel.setOnClickListener {
            removeFragment(this)
        }
    }

    companion object {
        fun newInstance() = CreateIdeaFragment()
    }
}
