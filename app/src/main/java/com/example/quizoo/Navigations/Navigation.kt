package com.example.quizoo.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.quizoo.MainPart.Mathematics
import com.example.quizoo.MainPart.MathematicsQuiz
import com.example.quizoo.MathematicsScreens.Board
import com.example.quizoo.MathematicsScreens.BoardTrue
import com.example.quizoo.MathematicsScreens.Show
import com.example.quizoo.MathematicsScreens.StartScreen
import com.example.quizoo.Screens.Login
import com.example.quizoo.Screens.SignUpScreen

@Composable
fun SetUpNavigation(
    navController: NavHostController
){
   NavHost(
       navController = navController,
       startDestination = Screens.mathematics.route
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


       composable(route = Screens.mathematics.route) {
           Mathematics(navController = navController)
       }
       composable(route = Screens.quizMathematics.route ){
           MathematicsQuiz(navController = navController)
       }

       composable(route = Screens.MathematicsStart.route ){
           StartScreen(navController)
       }


       composable(route = Screens.TrueFalseBoardMath.route ){
           Board(navController)
       }


       composable(route = Screens.MultipleBoardMath.route ){
           BoardTrue(navController)
       }

       composable(
           route = Screens.ResultMathematics.route,
           arguments = listOf(
               navArgument("correctCount") { defaultValue = 0 },
               navArgument("incorrectCount") { defaultValue = 0 },
               navArgument("skippedCount") { defaultValue = 0 }
           )
       ) { backStackEntry ->
           val correctCount = backStackEntry.arguments?.getInt("correctCount") ?: 0
           val incorrectCount = backStackEntry.arguments?.getInt("incorrectCount") ?: 0
           val skippedCount = backStackEntry.arguments?.getInt("skippedCount") ?: 0

           Show(navController, correctCount, incorrectCount, skippedCount)
       }



   }
}