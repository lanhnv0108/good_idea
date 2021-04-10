package com.example.do_an_cong_nghe_phan_mem.ui.client.standing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.do_an_cong_nghe_phan_mem.R

class StandingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stading, container, false)
    }

    companion object {
        fun newInstance() = StandingFragment()
    }
}