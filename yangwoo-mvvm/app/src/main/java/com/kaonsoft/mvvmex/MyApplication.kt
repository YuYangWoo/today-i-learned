package com.kaonsoft.mvvmex

import android.app.Application
import com.kaonsoft.mvvmex.module.myDiModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}