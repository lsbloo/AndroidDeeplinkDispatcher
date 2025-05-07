package com.student.journalapp.main.data.repository

import com.student.journalapp.main.data.source.RecoveryAllDeepLinkSource
import com.student.journalapp.main.domain.RecoveryDeepLinkResult
import com.student.journalapp.main.domain.entity.RecoveryDeepLinksMapper
import com.student.journalapp.main.domain.repository.MainRepository

class MainRepositoryImpl(
    private val source: RecoveryAllDeepLinkSource,
    private val mapper: RecoveryDeepLinksMapper
) : MainRepository {
    override suspend fun getAllDeepLinks(): RecoveryDeepLinkResult {
        val req = source.getAllDeepLinks()
        return if (req.isSuccessful) {
            RecoveryDeepLinkResult.Success(
                mapper.map(req.body()?.data ?: throw IllegalStateException("Failure to obain deeplinks")).deepLinks
            )
        } else {
            RecoveryDeepLinkResult.Error
        }
    }
}