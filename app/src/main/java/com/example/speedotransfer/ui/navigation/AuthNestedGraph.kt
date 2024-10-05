package com.example.speedotransfer.ui.navigation

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument

import com.example.speedotransfer.ui.signinandup.SecondSignUp
import com.example.speedotransfer.ui.signinandup.SignIn
import com.example.speedotransfer.ui.signinandup.SignUp

fun NavGraphBuilder.authGraph(navController: NavController, firstTime: Boolean, context: Context) {
    navigation(startDestination = Route.SIGNIN, route = Route.AUTH) {
        composable(route = Route.SIGNUP)
        {
            SignUp(navController)
        }
        composable(
            route = "${Route.COMPLETEPROFILE}/{name}/{email}/{password}",
            arguments = listOf(navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            ),

            ) {
            val name = it.arguments?.getString("name")!!
            val email = it.arguments?.getString("email")!!
            val password = it.arguments?.getString("password")!!
            SecondSignUp(navController, name, email, password)
        }
        composable(route = Route.SIGNIN) { SignIn(navController, firstTime, context,) }
        //composable(route = Route.TIMEOUT) { TimeOut(navController) }
    }
}

