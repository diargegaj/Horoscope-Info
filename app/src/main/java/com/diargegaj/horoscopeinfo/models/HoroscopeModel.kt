package com.diargegaj.horoscopeinfo.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Diar Gegaj on 21-05-02.
 */
data class HoroscopeModel (
    @SerializedName("date_range")
    val dateRange: String,

    @SerializedName("current_date")
    val currentDate: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("compatibility")
    val compatibility: String,

    @SerializedName("mood")
    val mood: String,

    @SerializedName("color")
    val color: String,

    @SerializedName("lucky_number")
    val luckyNumber: String,

    @SerializedName("lucky_time")
    val luckyTime: String
)