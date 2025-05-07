package com.student.journalapp.core.navigation.di

import androidx.navigation.NavController
import com.student.journalapp.core.navigation.RouterNavigation
import com.student.journalapp.core.navigation.RouterNavigationImpl
import org.koin.dsl.module

object RouterNavigationModule {
    fun onInitialize(navController: NavController) = module {
        single<RouterNavigation> { RouterNavigationImpl(navController) }
    }
}