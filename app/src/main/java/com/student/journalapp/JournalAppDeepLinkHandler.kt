package com.student.journalapp

import com.student.deeplinkdispatcher.deeplink.DeepLink
import com.student.journalapp.feature.folhasp.FolhaSPJournalActivity
import com.student.journalapp.feature.globo.GloboJournalActivity
import com.student.journalapp.feature.uol.UolJournalActivity

// Registry you deeplink here please!
interface JournalAppDeepLinkHandler {

    @DeepLink(
        value = "/uol",
        redirectClass = UolJournalActivity::class,
        "com.student.journalapp.feature.uol"
    )
    fun openUolJournalApp()

    @DeepLink(
        value = "/globo",
        redirectClass = GloboJournalActivity::class,
        "com.student.journalapp.feature.globo"
    )
    fun openGloboJournalApp()

    @DeepLink(
        value = "/folhasp",
        redirectClass = FolhaSPJournalActivity::class,
        "com.student.journalapp.feature.folhasp"
    )
    fun openFolhaSpJournalApp()

}