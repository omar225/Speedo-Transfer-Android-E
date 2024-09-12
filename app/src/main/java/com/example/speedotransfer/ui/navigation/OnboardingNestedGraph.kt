package com.example.speedotransfer.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.speedotransfer.ui.onboardingscreens.OnBoardingScreenOne
import com.example.speedotransfer.ui.onboardingscreens.OnBoardingScreenThree
import com.example.speedotransfer.ui.onboardingscreens.OnBoardingScreenTwo

fun NavGraphBuilder.onboardingGraph(navController: NavController){
    navigation(startDestination = Route.ONBOARDINGSCREEN1, route = Route.ONBOARDINGSCREEN){
        composable(route = Route.ONBOARDINGSCREEN1){ OnBoardingScreenOne(navController) }
        composable(route= Route.ONBOARDINGSCREEN2){ OnBoardingScreenTwo(navController) }
        composable(route= Route.ONBOARDINGSCREEN3) { OnBoardingScreenThree(navController) }
    }
}

