package com.diargegaj.horoscopeinfo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diargegaj.horoscopeinfo.R
import com.diargegaj.horoscopeinfo.adapter.ViewPagerAdapter
import com.diargegaj.horoscopeinfo.ui.fragments.HoroscopeInfoFragment
import kotlinx.android.synthetic.main.activity_signs_info.*

/**
 * Created by Diar Gegaj on 21-05-02.
 */
class SignsinfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signs_info)

        setupViewPager()

    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        horoscopeInfoViewPager.offscreenPageLimit = 3
        createFragments(adapter)
    }

    private fun createFragments(adapter: ViewPagerAdapter) {
        val yesterdayFragment = HoroscopeInfoFragment()
        val todayFragment = HoroscopeInfoFragment()
        val tomorrowFragment = HoroscopeInfoFragment()

        adapter.addFragment(yesterdayFragment, "Yesterday")
        adapter.addFragment(todayFragment, "Today")
        adapter.addFragment(tomorrowFragment, "Tomorrow")

        horoscopeInfoViewPager.adapter = adapter

        tabLayout.setupWithViewPager(horoscopeInfoViewPager)
    }

}