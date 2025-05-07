package com.student.journalapp.main.domain.repository

import com.student.journalapp.main.domain.RecoveryDeepLinkResult

interface MainRepository {
    suspend fun getAllDeepLinks(): RecoveryDeepLinkResult
}