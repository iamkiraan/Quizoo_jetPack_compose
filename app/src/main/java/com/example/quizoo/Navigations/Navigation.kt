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


       composable(
           route = Screens.mathematics.route,
       ){

           Mathematics()
       }
       composable(route = Screens.quizMathematics.route ){
           MathematicsQuiz(navController = navController)
       }


       //startScreen
       composable(
           route = Screens.MathematicsStart.route, arguments = listOf(
               navArgument("topic"){type = NavType.StringType},
               navArgument("image"){type = NavType.IntType},
               navArgument("id"){type = NavType.IntType}

           )
       ) {rest->
           val topic =  rest.arguments?.getString("topic")?:""
           val image = rest.arguments?.getInt("image") ?: 0
           val id = rest.arguments?.getInt("id")?:-1
           StartScreen(navController = navController,topic = topic,image =image,id = id)
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







       composable(
           route = Screens.MultipleBoardMath.route,
           arguments = listOf(
               navArgument("id"){type = NavType.IntType}
           )
       ){res->
           val id = res.arguments?.getInt("id")?:0
           BoardTrue(navController,id = id)
       }


















   }
}