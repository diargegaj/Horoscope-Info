package com.diargegaj.horoscopeinfo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Diar Gegaj on 21-05-02.
 */
@Entity(tableName = "horoscope_info")
data class HoroscopeModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("current_date")
    @ColumnInfo(name = "current_date")
    val currentDate: String,

    @SerializedName("date_range")
    @ColumnInfo(name = "date_range")
    val dateRange: String,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String,

    @SerializedName("compatibility")
    @ColumnInfo(name = "compatibility")
    val compatibility: String,

    @SerializedName("mood")
    @ColumnInfo(name = "mood")
    val mood: String,

    @SerializedName("color")
    @ColumnInfo(name = "color")
    val color: String,

    @SerializedName("lucky_number")
    @ColumnInfo(name = "lucky_number")
    val luckyNumber: String,

    @SerializedName("lucky_time")
    @ColumnInfo(name = "lucky_time")
    val luckyTime: String,

    @ColumnInfo(name = "sign")
    var sign: String,

    @ColumnInfo(name = "information_for")
    var informationFor: String
)