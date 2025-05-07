package com.student.journalapp.core.navigation

interface RouterNavigation {
    fun onNavigate(router: RouterNavigationEnum)
    fun onDisableBackPressed(disable: Boolean)
    fun onPopBackStack(router: RouterNavigationEnum)
}