package com.example.quizoo.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizoo.BottomNavBar.AppNavigation
import com.example.quizoo.MainPart.Mathematics
import com.example.quizoo.MainPart.MathematicsQuiz
import com.example.quizoo.Screens.Login
import com.example.quizoo.Screens.SignUpScreen

@Composable
fun SetUpNavigation(
    navController: NavHostController
){
   NavHost(
       navController = navController,
       startDestination = Screens.Login.route
   ){
       composable(
           route = Screens.Login.route
       ){
           Login(navController)
       }

       composable(
           route = Screens.Register.route
       ){
           SignUpScreen(navController)
       }

       composable(
           route = Screens.mathematics.route
       ){
           AppNavigation(navController)
       }

       composable(route = Screens.mathematics.route) {
           Mathematics()
       }


   }
}