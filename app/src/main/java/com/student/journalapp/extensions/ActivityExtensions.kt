package com.student.journalapp.extensions

import DeepLinkMapping
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder

private const val BASE_URL_PREFIX = "student://journalapp"
fun AppCompatActivity.resolveAndInitializeDeepLink() {
    val action = intent.action
    val page = action?.removePrefix(BASE_URL_PREFIX)
        ?: throw IllegalStateException("Failure to obtain url page deeplink")
    val kClassRedirect = DeepLinkMapping.getDeepLinkClass(url = page.toString())
    val deepLinkIntent = Intent(this, kClassRedirect?.java)

    val stackBuilder = TaskStackBuilder.create(this)

    stackBuilder.addNextIntentWithParentStack(deepLinkIntent)

    stackBuilder.startActivities()
}

fun Activity.resolveAndInitializeDeepLink() {
    val action = intent.action
    val page = action?.removePrefix(BASE_URL_PREFIX)
        ?: throw IllegalStateException("Failure to obtain url page deeplink")
    val kClassRedirect = DeepLinkMapping.getDeepLinkClass(url = page.toString())
    startActivity(Intent(this, kClassRedirect?.java))
}