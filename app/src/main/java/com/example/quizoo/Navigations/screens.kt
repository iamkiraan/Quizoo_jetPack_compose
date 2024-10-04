package com.example.quizoo.Navigations

 sealed class Screens(val route : String){
     object Login : Screens(route = "Login")
     object Register : Screens(route = "Register")
     object mathematics : Screens(route = "mathematics")

 }