package com.example.do_an_cong_nghe_phan_mem.ui.client.hompage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerContainerAdapter(
    fragment: FragmentManager,
    private var fragments: MutableList<Fragment>
) : FragmentPagerAdapter(
    fragment,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]
}
