package com.student.journalapp

import android.app.Application
import com.student.journalapp.core.NetworkModule
import com.student.journalapp.main.di.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module

class JournalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@JournalApplication)
            modules(appModule)
        }
    }
}

val appModule = listOf<Module>(
    NetworkModule.get(),
    MainModule.get()
)

fun <T> listOf(elements: T, elements1: List<T>): List<T> {
    return elements1
}
