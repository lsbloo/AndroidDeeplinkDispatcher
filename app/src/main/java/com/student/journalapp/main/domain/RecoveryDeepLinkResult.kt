package com.student.journalapp.main.domain

sealed class RecoveryDeepLinkResult {
    data class Success(val deeplink: List<String?>) : RecoveryDeepLinkResult()
    data object Error : RecoveryDeepLinkResult()
}