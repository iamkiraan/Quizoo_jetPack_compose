package com.example.quizoo.Navigations

 sealed class Screens(val route : String){
     object Login : Screens(route = "Login")
     object Register : Screens(route = "Register")
     object mathematics : Screens(route = "mathematics")
     object quizMathematics : Screens(route = "quizMathematics")
     object MathematicsStart : Screens(route = "MathematicsStart")
     object TrueFalseBoardMath : Screens(route = "TrueFalseBoard")
     object MultipleBoardMath : Screens(route = "MultipleBoardMath")
     object ResultMathematics : Screens(route = "resultMathematics?correctCount={correctCount}&incorrectCount={incorrectCount}&skippedCount={skippedCount}")

 }