package com.example.do_an_cong_nghe_phan_mem.ui.client.hompage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.do_an_cong_nghe_phan_mem.R
import com.example.do_an_cong_nghe_phan_mem.ui.client.develop.DevelopFragment
import com.example.do_an_cong_nghe_phan_mem.ui.client.home.IdeaFragment
import com.example.do_an_cong_nghe_phan_mem.ui.client.profile.ProfileFragment
import com.example.do_an_cong_nghe_phan_mem.ui.client.standing.StandingFragment
import com.example.do_an_cong_nghe_phan_mem.utils.MenuItems
import kotlinx.android.synthetic.main.fragment_home_page_profile.*

class HomPageFragment : Fragment() {

    private val ideaFragment = IdeaFragment.newInstance()
    private val standingFragment = StandingFragment.newInstance()
    private val developFragment = DevelopFragment.newInstance()
    private val profileFragment = ProfileFragment.newInstance()
    private val fragments = mutableListOf<Fragment>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
        viewPagerContainer.adapter = fragmentManager?.let { ViewPagerContainerAdapter(it, fragments) }
        initBottomItem()
        viewPagerContainer.offscreenPageLimit = 1
    }

    private fun initFragment() {
        fragments.apply {
            add(MenuItems.IDEA.ordinal, ideaFragment)
            add(MenuItems.STANDING.ordinal, standingFragment)
            add(MenuItems.DEVELOP.ordinal, developFragment)
            add(MenuItems.PROFILE.ordinal, profileFragment)
        }
    }

    private fun initBottomItem() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ideaItem -> {
                    viewPagerContainer.currentItem = MenuItems.IDEA.ordinal
                    true
                }
                R.id.standingItem -> {
                    viewPagerContainer.currentItem = MenuItems.STANDING.ordinal
                    true
                }
                R.id.developItem -> {
                    viewPagerContainer.currentItem = MenuItems.DEVELOP.ordinal
                    true
                }
                R.id.profileItem -> {
                    viewPagerContainer.currentItem = MenuItems.PROFILE.ordinal
                    true
                }
                else -> false
            }
        }
        viewPagerContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavigation.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })
    }

    companion object {
        fun newInstance() = HomPageFragment()
    }
}
