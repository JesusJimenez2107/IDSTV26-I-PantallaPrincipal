package com.example.pantallaprincipal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pantallaprincipal.screens.LoginScreen
import com.example.pantallaprincipal.screens.SingUpScreen
import com.example.pantallaprincipal.screens.WelcomeScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ){
        composable ("welcome"){
            WelcomeScreen(navController)
        }

        composable ("signup"){
            SingUpScreen(navController)
        }

        composable ("login"){
            LoginScreen(navController)
        }
    }
}
