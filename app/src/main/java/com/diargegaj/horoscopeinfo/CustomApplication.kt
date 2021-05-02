package com.diargegaj.horoscopeinfo

import android.app.Application
import android.content.Context

/**
 * Created by Diar Gegaj on 21-05-03.
 */
class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: Context
            private set
    }
}