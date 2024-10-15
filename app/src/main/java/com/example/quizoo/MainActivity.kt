package com.example.quizoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import com.example.quizoo.Screens.SignUpScreen


class MainActivity : ComponentActivity() {
    
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

//         navController = rememberNavController()
//
//        SetUpNavigation(navController = navController)
            SignUpScreen(navController = navController)


        }
    }
}