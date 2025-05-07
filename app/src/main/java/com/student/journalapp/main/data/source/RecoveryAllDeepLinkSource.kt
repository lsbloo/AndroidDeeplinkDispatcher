package com.student.journalapp.main.data.source

import com.student.journalapp.main.data.api.RecoveryDeepLinksService

class RecoveryAllDeepLinkSource(
    private val service: RecoveryDeepLinksService
) {
    suspend fun getAllDeepLinks() = service.getAllDeepLinks()
}