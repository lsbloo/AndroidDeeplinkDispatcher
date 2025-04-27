package com.student.journalapp.main.data.repository

import com.student.journalapp.main.data.source.RecoveryAllDeepLinkSource
import com.student.journalapp.main.domain.repository.MainRepository

class MainRepositoryImpl(
    private val source: RecoveryAllDeepLinkSource
) : MainRepository {

    override fun getAllDeepLinks() {
        TODO("Not yet implemented")
    }
}