package com.ticonsys.cleanarchitecturedemo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ticonsys.cleanarchitecturedemo.util.Route
import com.ticonsys.cleanarchitecturedemo.presentation.features.home.HomeScreen
import com.ticonsys.cleanarchitecturedemo.presentation.features.registration.RegistrationScreen
import com.ticonsys.cleanarchitecturedemo.presentation.theme.CleanArchitectureDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Registration.route) {
        composable(Route.Registration.route) {
            RegistrationScreen { route ->
                navController.navigate(route){
                    popUpTo(id = navController.graph.startDestinationId){
                        inclusive = true
                    }
                }
            }
        }

        composable(Route.Home.route) {
            HomeScreen()
        }
    }
}
