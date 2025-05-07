package com.student.journalapp.main.domain.usecase

import com.student.journalapp.main.domain.RecoveryDeepLinkResult
import com.student.journalapp.main.domain.repository.MainRepository

class RecoveryAllDeepLinksUseCase(
    private val mainRepository: MainRepository,
) {
    suspend operator fun invoke(): RecoveryDeepLinkResult = mainRepository.getAllDeepLinks()
}