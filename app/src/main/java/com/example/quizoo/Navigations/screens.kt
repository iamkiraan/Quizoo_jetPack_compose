package com.example.quizoo.Navigations

 sealed class Screens(val route : String){
     object Login : Screens(route = "Login")
     object Register : Screens(route = "Register")
     object mathematics : Screens(route = "mathematics")
     object quizMathematics : Screens(route = "quizMathematics")
     object MathematicsStart : Screens(route = "MathematicsStart/{topic}/{image}/{id}") {
         fun getTopic(topic: String, image: Int, id: Int): String {
             return "MathematicsStart/$topic/$image/$id"
         }
     }



     object MultipleBoardMath : Screens(route = "MultipleBoardMath/{id}"){
         fun getId(id:Int):String{
             return "MultipleBoardMath/$id"
         }
     }
     object ResultMathematics : Screens(route = "ResultMathematics/{correct}/{incorrect}/{skipped}")




 }