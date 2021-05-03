package com.diargegaj.horoscopeinfo.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.diargegaj.horoscopeinfo.models.HoroscopeModel
import com.diargegaj.horoscopeinfo.repository.HoroscopeInfoRepository

/**
 * Created by Diar Gegaj on 21-05-03.
 */
class HoroscopeInfoFragmentViewModel: ViewModel() {
    private val repository: HoroscopeInfoRepository = HoroscopeInfoRepository()

    fun getHoroscopeInfo(sign: String, day: String): LiveData<HoroscopeModel> {
        return repository.getHoroscopeInfo(sign, day)
    }
}