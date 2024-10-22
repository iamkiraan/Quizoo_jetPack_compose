package com.example.quizoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quizoo.MainPart.Mathematics
import com.example.quizoo.MainPart.MathematicsQuiz
import com.example.quizoo.MathematicsScreens.Board
import com.example.quizoo.MathematicsScreens.BoardTrue
import com.example.quizoo.MathematicsScreens.StartScreen
import com.example.quizoo.Navigations.SetUpNavigation
import com.example.quizoo.Screens.SignUpScreen


class MainActivity : ComponentActivity() {
    
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

       navController = rememberNavController()

        SetUpNavigation(navController = navController)
           // MathematicsQuiz(navController = navController)
           //BoardTrue(navController = navController)

        }
    }
}