package com.diargegaj.horoscopeinfo.service

import com.diargegaj.horoscopeinfo.models.HoroscopeModel
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Diar Gegaj on 21-05-02.
 */
interface HoroscopeService {

    @POST("/?day=today")
    fun getHoroscopeInfoPerSign(
        @Query("sign") sign: String
    ): Observable<HoroscopeModel>

    companion object {
        const val API_LINK = "https://sameer-kumar-aztro-v1.p.rapidapi.com"
    }
}