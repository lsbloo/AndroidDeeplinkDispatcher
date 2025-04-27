package com.student.journalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import com.student.deeplinkdispatcher.deeplink.core.DeepLink
import dev.forcetower.deeplinked.R


//@DeepLink(url = "example://journal")
class JournalHandlerDeepLinkDistpacherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)
    }
}