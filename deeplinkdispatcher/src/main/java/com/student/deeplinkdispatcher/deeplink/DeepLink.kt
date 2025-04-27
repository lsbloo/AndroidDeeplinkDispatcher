package com.student.deeplinkdispatcher.deeplink

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DeepLink(val value: String)