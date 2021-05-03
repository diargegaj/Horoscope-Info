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
    private lateinit var signNameFromExtras: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signs_info)
        signNameFromExtras = intent.getStringExtra(SIGN_NAME)!!
        setupViewPager()

    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        horoscopeInfoViewPager.offscreenPageLimit = 3
        createFragments(adapter)
    }

    private fun createFragments(adapter: ViewPagerAdapter) {
        val yesterdayBundle = Bundle()
        yesterdayBundle.putString(DAY, "yesterday")
        yesterdayBundle.putString(SIGN_NAME, signNameFromExtras)

        val yesterdayFragment = HoroscopeInfoFragment()
        yesterdayFragment.arguments = yesterdayBundle

        val todayBundle = Bundle()
        todayBundle.putString(DAY, "today")
        todayBundle.putString(SIGN_NAME, signNameFromExtras)

        val todayFragment = HoroscopeInfoFragment()
        todayFragment.arguments = todayBundle


        val tomorrowBundle = Bundle()
        tomorrowBundle.putString(DAY, "tomorrow")
        tomorrowBundle.putString(SIGN_NAME, signNameFromExtras)

        val tomorrowFragment = HoroscopeInfoFragment()
        tomorrowFragment.arguments = tomorrowBundle

        adapter.addFragment(yesterdayFragment, "Yesterday")
        adapter.addFragment(todayFragment, "Today")
        adapter.addFragment(tomorrowFragment, "Tomorrow")

        horoscopeInfoViewPager.adapter = adapter

        tabLayout.setupWithViewPager(horoscopeInfoViewPager)
        tabLayout.getTabAt(1)?.select()
    }

    companion object {
        const val DAY = "DAY"
        const val SIGN_NAME = "SignName"
    }

}