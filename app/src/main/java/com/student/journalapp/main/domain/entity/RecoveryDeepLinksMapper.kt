package com.student.journalapp.main.domain.entity

import com.student.core.domain.Mapper
import com.student.journalapp.main.data.model.DeepLinkData

class RecoveryDeepLinksMapper : Mapper<List<DeepLinkData>, RecoveryDeepLinks> {
    override fun map(input: List<DeepLinkData>): RecoveryDeepLinks {
        val deepLinks = input.map { it.deepLink }
        return RecoveryDeepLinks(deepLinks)
    }
}
data class RecoveryDeepLinks(
    val deepLinks: List<String?>
)