package com.diargegaj.horoscopeinfo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diargegaj.horoscopeinfo.dao.HoroscopeInfoDao
import com.diargegaj.horoscopeinfo.models.HoroscopeModel

/**
 * Created by Diar Gegaj on 21-05-03.
 */
@Database(entities = [HoroscopeModel::class], version = 1)
abstract class HoroscopeInfoDatabase: RoomDatabase() {
    abstract fun getHoroscopeInfoDAO(): HoroscopeInfoDao
}