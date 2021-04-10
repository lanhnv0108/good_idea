package com.example.do_an_cong_nghe_phan_mem.ui.client.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.ui.login.LoginFragment
import com.example.do_an_cong_nghe_phan_mem.utils.replaceFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLogOut()
    }

    private fun onLogOut() {
        buttonLoginOut.setOnClickListener {
            replaceFragment(LoginFragment.newInstance(), R.id.containerLayout)
        }
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}
