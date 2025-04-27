package com.student.deeplinkdispatcher.deeplink

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class DeepLink(val value: String, val redirectClass: KClass<*>, val packAge: String)