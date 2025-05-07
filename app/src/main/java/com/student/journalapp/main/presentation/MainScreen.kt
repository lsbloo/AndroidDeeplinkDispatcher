package com.student.journalapp.main.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: MainActivityViewModel = koinViewModel {
        parametersOf(navController)
    }
) {

    viewModel.onViewCreated()
}