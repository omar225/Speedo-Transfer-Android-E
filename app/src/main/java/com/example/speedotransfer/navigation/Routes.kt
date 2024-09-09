package com.example.speedotransfer.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.onboardingscreens.OnBoardingScreenOne
import com.example.speedotransfer.ui.onboardingscreens.OnBoardingScreenThree
import com.example.speedotransfer.ui.onboardingscreens.OnBoardingScreenTwo
import com.example.speedotransfer.ui.signinandup.SecondSignUp
import com.example.speedotransfer.ui.signinandup.SignIn
import com.example.speedotransfer.ui.signinandup.SignUp
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.P300

object Route{

    const val SIGNUP = "signup"
    const val COMPLETEPROFILE = "complete profile"
    const val SIGNIN = "sign in"

    const val HOME = "home"
    const val MORE = "more"
    const val TRANSACTIONS = "transactions"

    const val AMONT= "amount"
    const val CONFIRMATION = "confirmation"
    const val PAYMENT = "payment"

    const val ONBOARDINGSCREEN1 = "onboarding1"
    const val ONBOARDINGSCREEN2 = "onboarding2"
    const val ONBOARDINGSCREEN3 = "onboarding3"

    const val SERVERERROR = "server error"
    const val NETWORKERROR = "network error"

    const val TRASACTIONDETAILS = "transaction details"

    const val FAVOURITES = "favourites"
    const val PROFILE = "profile"

    const val PROFILEINFORMATION = "profile information"
    const val EDITPROFILE = "edit profile"
    const val CHANGEPASSWORD = "change password"
    const val SETTINGS = "settings"

    const val NOTIFICATIONS = "notifications"

    const val ONBOARDINGSCREEN = "onboardingscreen"
    const val AUTH = "auth"
    const val MAINAPP = "mainapp"

}

sealed class NavigationItem(val route: String, val icon: Int, val title: String) {
    object Home : NavigationItem(Route.HOME, R.drawable.home, "Home")
    object More : NavigationItem(Route.MORE, R.drawable.more, "More")
    object Transactions : NavigationItem(Route.TRANSACTIONS, R.drawable.history_1, "Transactions")
    object Transfer : NavigationItem(Route.AMONT, R.drawable.transfer_1, "Transfer")
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.ONBOARDINGSCREEN) {

        onboardingGraph(navController)
        authGraph(navController)

        composable(route = Route.MAINAPP) {
            val navControllerTwo = rememberNavController()

            Scaffold(

                bottomBar = {
                    val items = listOf(
                        NavigationItem.Home,
                        NavigationItem.Transfer,
                        NavigationItem.Transactions,
                        NavigationItem.More
                    )
                    BottomNavigation(
                        backgroundColor = Color.White,
                        contentColor = Color.Black,
                        modifier = modifier.clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    ) {
                        val selectedItem = remember { mutableStateOf(0) }
                        items.forEachIndexed { index, item ->
                            BottomNavigationItem(
                                icon = {
                                    androidx.compose.material.Icon(
                                        painter = painterResource(
                                            id = item.icon
                                        ), contentDescription = item.title,
                                        tint = if (selectedItem.value == index) P300 else Color.Black,
                                        modifier = modifier.size(20.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        text = item.title,
                                        color = if (selectedItem.value == index) P300 else Color.Black,
                                        style = AppTypography.smallFont
                                    )
                                },
                                selected = selectedItem.value == index,
                                onClick = {
                                    selectedItem.value = index
                                    navControllerTwo.navigate(item.route)
                                }
                            )
                        }
                    }
                }
            )



            {
                        MainScreensGraph(navControllerTwo) {
                            navController.navigate(Route.AUTH) {
                                popUpTo(0)
                            }
                        }

                }

        }
    }
}



