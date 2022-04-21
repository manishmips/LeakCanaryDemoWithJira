package com.mt.myleakcanary.app

import android.app.Application
import com.mt.leakcanarysample.LeakCanaryUploaderInit

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        LeakCanaryUploaderInit.initLeakCanary()
    }
}