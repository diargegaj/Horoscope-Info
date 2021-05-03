package com.diargegaj.horoscopeinfo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diargegaj.horoscopeinfo.models.HoroscopeModel

/**
 * Created by Diar Gegaj on 21-05-03.
 */
@Dao
interface HoroscopeInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHoroscopeInfo(horoscopeInfo: HoroscopeModel)

    @Query("SELECT * FROM horoscope_info WHERE sign = :sign AND information_for = :day")
    fun getHoroscopeInfo(sign: String, day: String): LiveData<HoroscopeModel>

    @Query("DELETE FROM horoscope_info WHERE sign = :sign AND information_for = :day")
    fun deleteHoroscopeInfoPer(sign: String, day: String)

}