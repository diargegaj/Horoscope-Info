package com.diargegaj.horoscopeinfo.helpers

import androidx.lifecycle.LiveData
import com.diargegaj.horoscopeinfo.instances.RoomInstance
import com.diargegaj.horoscopeinfo.models.HoroscopeModel

/**
 * Created by Diar Gegaj on 21-05-03.
 */
class DatabaseHelper {
    private val horoscopeInfoDAO = RoomInstance.db.getHoroscopeInfoDAO()

    fun insertHoroscopeInfo(horoscopeInfo: HoroscopeModel) {
        horoscopeInfoDAO.insertHoroscopeInfo(horoscopeInfo)
    }

    fun getHoroscopeInfo(sign: String, day: String): LiveData<HoroscopeModel> {
        return horoscopeInfoDAO.getHoroscopeInfo(sign, day)
    }

    fun deleteInfoPer(sign: String, day: String) {
        horoscopeInfoDAO.deleteHoroscopeInfoPer(sign, day)
    }

}