package com.example.speedotransfer.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

import com.example.speedotransfer.ui.signinandup.SecondSignUp
import com.example.speedotransfer.ui.signinandup.SignIn
import com.example.speedotransfer.ui.signinandup.SignUp

fun NavGraphBuilder.authGraph(navController: NavController){
    navigation(startDestination = Route.SIGNIN, route = Route.AUTH){
        composable(route = Route.SIGNUP){ SignUp(navController) }
        composable(route = Route.COMPLETEPROFILE){ SecondSignUp(navController) }
        composable(route = Route.SIGNIN){ SignIn(navController) }
    }
}