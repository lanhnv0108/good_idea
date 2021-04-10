package com.example.do_an_cong_nghe_phan_mem.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.ui.admin.homepageadmin.HomPageAdminFragment
import com.example.do_an_cong_nghe_phan_mem.ui.client.hompage.HomPageFragment
import com.example.do_an_cong_nghe_phan_mem.utils.replaceFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSuccessLogin()
    }

    private fun onSuccessLogin() {
        buttonLogin.setOnClickListener {
            if (textFieldEmail.editText?.text.toString()
                    .isEmpty() || textFieldPassword.editText?.text.toString().isEmpty()
            ) {
                Toast.makeText(context, "Vui lòng nhập tài khoản !!!", Toast.LENGTH_LONG).show()
            } else {
                if (checkRoles()) {
                    replaceFragment(HomPageAdminFragment.newInstance(), R.id.containerLayout)
                } else {
                    replaceFragment(HomPageFragment.newInstance(), R.id.containerLayout)
                }
            }
        }
    }

    private fun checkRoles(): Boolean {
        if (textFieldEmail.editText?.text.toString() == "admin" && textFieldPassword.editText?.text.toString() == "123") {
            return true
        } else if (textFieldEmail.editText?.text.toString() == "client" && textFieldPassword.editText?.text.toString() == "123") {
            return false
        }
        return true
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}