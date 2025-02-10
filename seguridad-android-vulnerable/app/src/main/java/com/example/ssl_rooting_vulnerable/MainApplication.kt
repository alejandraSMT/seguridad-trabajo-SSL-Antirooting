package com.example.ssl_rooting_vulnerable

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    init {
        instance = this

    }

    companion object {
        private var instance : MainApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }

    }


}