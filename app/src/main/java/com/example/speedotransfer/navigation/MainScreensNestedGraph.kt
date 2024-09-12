package com.example.speedotransfer.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.ui.errorscreens.ErrorConnection
import com.example.speedotransfer.ui.mainscreens.FavouriteScreen
import com.example.speedotransfer.ui.mainscreens.HomeScreen
import com.example.speedotransfer.ui.mainscreens.MoreScreen
import com.example.speedotransfer.ui.mainscreens.NotificationsScreen
import com.example.speedotransfer.ui.profile.ChangePasswordScreen
import com.example.speedotransfer.ui.profile.EditProfileScreen
import com.example.speedotransfer.ui.profile.ProfileInformationScreen
import com.example.speedotransfer.ui.profile.ProfileScreen
import com.example.speedotransfer.ui.profile.SettingsScreen
import com.example.speedotransfer.ui.transaction.TransactionDetailsScreen
import com.example.speedotransfer.ui.transaction.TransactionHistory
import com.example.speedotransfer.ui.transferscreens.AmontScreen
import com.example.speedotransfer.ui.transferscreens.ConfirmationScreen
import com.example.speedotransfer.ui.transferscreens.PaymentScreen

@Composable
fun MainScreensGraph(navController: NavHostController, modifier:Modifier=Modifier,logout:()->Unit){

    NavHost(navController = navController, startDestination = Route.HOME, route = Route.MAINAPP){

        composable(route = Route.HOME){ HomeScreen(navController) }
        composable(route = Route.MORE){ MoreScreen(navController,logout=logout) }
        composable(route = Route.NOTIFICATIONS){ NotificationsScreen(navController) }
        composable(route= Route.AMONT){ AmontScreen(navController) }
        composable(route= Route.CONFIRMATION){ ConfirmationScreen(navController)}
        composable(route= Route.PAYMENT){ PaymentScreen(navController) }
        composable(route= Route.TRANSACTIONS) { TransactionHistory(navController) }
        composable(route= Route.TRASACTIONDETAILS) { TransactionDetailsScreen(navController) }
        composable(route= Route.FAVOURITES) { FavouriteScreen(navController) }
        composable(route= Route.PROFILE) { ProfileScreen(navController) }
        composable(route= Route.SETTINGS) { SettingsScreen(navController) }
        composable(route= Route.PROFILEINFORMATION) { ProfileInformationScreen(navController) }
        composable(route= Route.EDITPROFILE) { EditProfileScreen(navController) }
        composable(route= Route.CHANGEPASSWORD) { ChangePasswordScreen(navController) }
    }
}