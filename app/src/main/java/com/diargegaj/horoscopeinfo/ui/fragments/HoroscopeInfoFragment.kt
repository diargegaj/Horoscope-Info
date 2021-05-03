package com.diargegaj.horoscopeinfo.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.diargegaj.horoscopeinfo.R
import com.diargegaj.horoscopeinfo.ui.activity.SignsinfoActivity.Companion.DAY
import com.diargegaj.horoscopeinfo.ui.activity.SignsinfoActivity.Companion.SIGN_NAME
import com.diargegaj.horoscopeinfo.ui.viewModels.HoroscopeInfoFragmentViewModel
import kotlinx.android.synthetic.main.fragment_horoscope_info.*

/**
 * Created by Diar Gegaj on 21-05-03.
 */
class HoroscopeInfoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_horoscope_info, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("diari1", "this.arg = ${this.arguments}")
        val bundle = this.arguments
        val signName = bundle?.getString(SIGN_NAME)
        val day = bundle?.getString(DAY)

        Log.d("diari1", "bundle = $bundle")

        Log.d("diari1", "extras come to fragment: $signName, $day")

        val horoscopeInfoViewModel = ViewModelProvider(this).get(HoroscopeInfoFragmentViewModel::class.java)

        horoscopeInfoViewModel.getHoroscopeInfo(signName!!, day!!).observe(viewLifecycleOwner, {
            if (it != null) {

                horoscopeDateTextView.text =
                        String.format(context!!.getString(R.string.horoscope_per_date), it.currentDate)

                signSayToYouTextView.text =
                    String.format(context!!.getString(R.string.sign_says_to_you), it.sign, it.description)

                compatibilityTextView.text =
                    String.format(context!!.getString(R.string.compatibility), it.compatibility)

                moodTextView.text =
                    String.format(context!!.getString(R.string.mood), it.mood)

                luckyNumberTextView.text =
                    String.format(context!!.getString(R.string.lucky_number_for_today), it.luckyNumber)

                luckyTimeTextViw.text =
                    String.format(context!!.getString(R.string.lucky_time_for_today), it.luckyTime)
            }
        })

    }
}