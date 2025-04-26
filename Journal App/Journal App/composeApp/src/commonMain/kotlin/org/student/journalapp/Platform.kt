package org.student.journalapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform