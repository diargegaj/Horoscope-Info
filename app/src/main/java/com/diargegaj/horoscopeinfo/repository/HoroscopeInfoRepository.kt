package com.diargegaj.horoscopeinfo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.diargegaj.horoscopeinfo.helpers.DatabaseHelper
import com.diargegaj.horoscopeinfo.instances.RetrofitInstance
import com.diargegaj.horoscopeinfo.models.HoroscopeModel
import io.reactivex.schedulers.Schedulers

/**
 * Created by Diar Gegaj on 21-05-03.
 */
class HoroscopeInfoRepository {
    private val databaseHelper = DatabaseHelper()
    private val TAG = "HoroscopeInfoRepository"

    fun getHoroscopeInfo(sign: String, day: String): LiveData<HoroscopeModel> {
        val dis = RetrofitInstance.service.getHoroscopeInfoPerSign(sign, day)
            .subscribeOn(Schedulers.io())
            .subscribe ({
                it.sign = sign
                it.informationFor = day
                databaseHelper.deleteInfoPer(sign, day)
                databaseHelper.insertHoroscopeInfo(it)
                Log.d(TAG, "successfully inserted $it")
            }, {
                Log.d(TAG, "Failed to get data from API ${it.message}", it)
            })

        return databaseHelper.getHoroscopeInfo(sign, day)
    }

}