package com.example.do_an_cong_nghe_phan_mem.ui.admin.homepageadmin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.ui.admin.approve.ApproveFragment
import com.example.do_an_cong_nghe_phan_mem.ui.admin.approved.ApprovedFragment
import com.example.do_an_cong_nghe_phan_mem.ui.client.profile.ProfileFragment
import com.example.do_an_cong_nghe_phan_mem.utils.MenuItems
import kotlinx.android.synthetic.main.fragment_home_page_admin.*

class HomPageAdminFragment : Fragment() {

    private val approveFragment = ApproveFragment.newInstance()
    private val approvedFragment = ApprovedFragment.newInstance()
    private val profileFragment = ProfileFragment.newInstance()
    private val fragmentsAdmin = mutableListOf<Fragment>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
        fragmentManager?.let {
            viewPagerContainerAdmin.adapter = ViewPagerContainerAdapterAdmin(it, fragmentsAdmin)
            initBottomItem()
        }

    }

    private fun initFragment() {
        fragmentsAdmin.apply {
            add(0, approveFragment)
            add(1, approvedFragment)
            add(2, profileFragment)
        }
    }

    private fun initBottomItem() {
        bottomNavigationAdmin.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.approveItem -> {
                    viewPagerContainerAdmin.currentItem = 0
                    true
                }
                R.id.approvedItem -> {
                    viewPagerContainerAdmin.currentItem = 1
                    true
                }
                R.id.profileItemAdmin -> {
                    viewPagerContainerAdmin.currentItem = 2
                    true
                }
                else -> false
            }
        }
        viewPagerContainerAdmin.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavigationAdmin.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })
    }

    companion object {
        fun newInstance() = HomPageAdminFragment()
    }
}
