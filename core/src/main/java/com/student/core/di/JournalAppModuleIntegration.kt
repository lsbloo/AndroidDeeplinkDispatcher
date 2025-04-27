package com.student.core.di

import org.koin.core.module.Module

interface JournalAppModuleIntegration {
    fun getPresentation(): Module
    fun getDomain(): Module
    fun getData(): Module
    fun getExtras(): Module
}