package com.student.journalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.deeplinkdispatcher.deeplink.DeepLink

@DeepLink(value = "example://journal")
class JournalHandlerDeepLinkDistpacherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

        //DeepLinkMapping.handle(this, intent)
    }
}