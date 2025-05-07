package com.student.journalapp.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.student.journalapp.core.navigation.RouterNavigationEnum
import com.student.journalapp.core.navigation.di.RouterNavigationModule
import org.koin.core.context.loadKoinModules
import androidx.compose.runtime.LaunchedEffect
import com.student.journalapp.main.data.model.GetAllDeepLinksResponse
import com.student.journalapp.main.presentation.MainScreen
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        fun addition_isCorrect() {
            val jsonResponse = """
{
    "data": [
        {
            "deeplink": "student://journalapp/uol"
        },
        {
            "deeplink": "student://journalapp/globo"
        },
        {
            "deeplink": "student://journaapp/folhasp"
        }
    ]
}
"""

            val response = Json.decodeFromString<GetAllDeepLinksResponse>(jsonResponse)
            Log.d("Response", response.toString())
        }

        addition_isCorrect()
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = RouterNavigationEnum.MAIN_SCREEN.name
                ) {
                    composable(route = RouterNavigationEnum.MAIN_SCREEN.name) {
                        MainScreen()
                    }
                }
            }
        }
    }
}