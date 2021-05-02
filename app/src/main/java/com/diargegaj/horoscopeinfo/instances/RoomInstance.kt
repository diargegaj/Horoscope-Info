package com.diargegaj.horoscopeinfo.instances

import androidx.room.Room
import com.diargegaj.horoscopeinfo.CustomApplication
import com.diargegaj.horoscopeinfo.database.HoroscopeInfoDatabase

/**
 * Created by Diar Gegaj on 21-05-03.
 */
object RoomInstance {
    val db = Room.databaseBuilder(CustomApplication.instance, HoroscopeInfoDatabase::class.java, "horoscope-info-database").build()
}