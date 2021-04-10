package com.example.do_an_cong_nghe_phan_mem

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.do_an_cong_nghe_phan_mem.ui.login.LoginFragment
import com.example.do_an_cong_nghe_phan_mem.ui.viewmodel.MainViewModel
import com.example.do_an_cong_nghe_phan_mem.utils.addFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFlags()
        addFragment(LoginFragment.newInstance(), R.id.containerLayout)
    }

    override fun onResume() {
        super.onResume()
        Log.e("test" , "onResum")
        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                MainViewModel::class.java
            )
        viewModel.getAllIdea?.observe(this, {
            Log.e("test", it.toString())
            Log.e("test", "hdkjahdkjahdhakjd")
        })
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            currentFocus?.let {
                if (it is EditText){
                    hideKeyboard(it)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private fun setFlags() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
