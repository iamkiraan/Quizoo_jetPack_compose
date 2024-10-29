package com.example.quizoo.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
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
               navArgument("correct") { type = NavType.IntType },
               navArgument("incorrect") { type = NavType.IntType },
               navArgument("skipped") { type = NavType.IntType }
           )
       ) { backStackEntry ->
           val correctAnswers = backStackEntry.arguments?.getInt("correct") ?: 0
           val incorrectAnswers = backStackEntry.arguments?.getInt("incorrect") ?: 0
           val skipped = backStackEntry.arguments?.getInt("skipped") ?: 0
           Show(navController = navController, correct = correctAnswers, incorrect = incorrectAnswers, skipped = skipped)
       }




   }
}