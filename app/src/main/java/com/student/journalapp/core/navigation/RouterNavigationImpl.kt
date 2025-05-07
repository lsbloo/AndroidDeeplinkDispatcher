package com.student.journalapp.core.navigation

import android.util.Log
import androidx.navigation.NavController

class RouterNavigationImpl(private val navController: NavController) : RouterNavigation {

    init {
        Log.d("RouterNavigationImpl", "RouterNavigationImpl initialized")
    }


    override fun onNavigate(router: RouterNavigationEnum) {
        navController.navigate(router.name)
    }

    override fun onDisableBackPressed(disable: Boolean) {
        // TODO: Implement logic to disable back pressed
    }

    override fun onPopBackStack(router: RouterNavigationEnum) {
        navController.popBackStack(router.name, false)
    }
}