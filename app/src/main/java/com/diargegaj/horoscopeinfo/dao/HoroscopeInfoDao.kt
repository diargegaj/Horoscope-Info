package com.diargegaj.horoscopeinfo.dao

import androidx.room.Insert
import androidx.room.Query
import com.diargegaj.horoscopeinfo.models.HoroscopeModel

/**
 * Created by Diar Gegaj on 21-05-03.
 */
interface HoroscopeInfoDao {

    @Insert
    fun insertHoroscopeInfo(horoscopeInfo: HoroscopeModel)

    @Query("SELECT * FROM horoscope_info")
    fun getAllHoroscopeInfo(): List<HoroscopeModel>
}