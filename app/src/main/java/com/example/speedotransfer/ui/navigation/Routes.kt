package com.example.speedotransfer.ui.navigation

import android.accounts.Account
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.model.AccountDTO
import com.example.speedotransfer.model.CustomerDTO
import com.example.speedotransfer.ui.signinandup.SplashScreen
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G200
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
    const val SplashScreen = "splash"
    const val TIMEOUT = "timeout"

}

sealed class NavigationItem( val icon: Int, val title: String) {
    object Home : NavigationItem( R.drawable.home, "Home")
    object More : NavigationItem( R.drawable.more, "More")
    object Transactions : NavigationItem( R.drawable.history_1, "Transactions")
   // object myCards: NavigationItem(Route.FAVOURITES, R.drawable.cards_1, "My cards")
    object Transfer : NavigationItem( R.drawable.transfer_1, "Transfer")
}
     fun fetchCustomerDataFromPreferences(sharedPref: SharedPreferences): Pair<CustomerDTO,AccountDTO>{

         val account= AccountDTO(
             accountNumber = sharedPref.getString("accountNumber","") ?:"",
             accountName = sharedPref.getString("accountName", "") ?:"",
             balance = sharedPref.getInt("balance",0 ) ?:0
         )
         val customer = CustomerDTO(
             name = sharedPref.getString("customerName", "") ?:"",
             email=sharedPref.getString("customerEmail", "") ?:"",
             accounts=listOf(account)
         )
         return Pair( customer,account)

     }

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val reader = context.getSharedPreferences("FirstTime", Context.MODE_PRIVATE)
    val firstTime = reader.getBoolean("firstTime", true)

    val sharedPre: SharedPreferences = context.getSharedPreferences("customerData", MODE_PRIVATE)

    NavHost(navController = navController, startDestination =Route.SplashScreen ) {
        composable(route = Route.SplashScreen) {
            SplashScreen(navController,firstTime)
        }
        onboardingGraph(navController)

        authGraph(navController,firstTime,context)

        composable(route = Route.MAINAPP) {
            val navControllerTwo = rememberNavController()
            val (customer,account) = fetchCustomerDataFromPreferences(sharedPre)
            Scaffold(

                bottomBar = {
                    val items = listOf(
                        NavigationItem.Home,
                        NavigationItem.Transfer,
                        NavigationItem.Transactions,
                       // NavigationItem.myCards,
                        NavigationItem.More
                    )
                    BottomNavigation(

                        backgroundColor = Color.White,
                        contentColor = G200,
                        modifier = modifier.clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    ) {
                        val selectedItem = remember { mutableStateOf(0) }

                        items.forEachIndexed { index, item ->
                            BottomNavigationItem(
                                modifier = modifier.navigationBarsPadding(),
                                icon = {
                                    Icon(
                                        painter = painterResource(
                                            id = item.icon
                                        ), contentDescription = item.title,
                                        tint = if (selectedItem.value == index) P300 else G200,
                                        modifier = modifier.size(20.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        text = item.title,
                                        color = if (selectedItem.value == index) P300 else G200,
                                        style = AppTypography.smallFont
                                    )
                                },
                                selected = selectedItem.value == index,
                                onClick = {
                                    selectedItem.value = index
                                    if(item.title == "Home")
                                        navControllerTwo.navigate("${Route.HOME}/${customer.name}/${account.balance}/${account.accountNumber}",)
                                    else if(item.title == "Transfer")
                                        navControllerTwo.navigate("${Route.AMONT}/${account.accountNumber}",)
                                    else if(item.title == "Transactions")
                                        navControllerTwo.navigate("${Route.TRANSACTIONS}/${account.accountNumber}")
                                    else
                                        navControllerTwo.navigate("${Route.MORE}/${account.accountNumber}")

                                }
                            )
                        }
                    }
                }
            )
            {_ ->
                        MainScreensGraph(navControllerTwo) {
                            navController.navigate(Route.AUTH) {
                                popUpTo(0)
                            }
                        }

                }

        }
    }
}



