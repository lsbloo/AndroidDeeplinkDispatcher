package com.student.journalapp

import android.app.Application
import android.util.Log
import com.student.journalapp.core.network.NetworkModule
import com.student.journalapp.main.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module

class JournalApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("JournalApplication", "onCreate")
        startKoin {
            androidLogger()
            androidContext(this@JournalApplication)
            modules(NetworkModule.get())
            modules(MainModule.get())
        }
    }
}
