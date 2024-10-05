package com.example.speedotransfer.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.speedotransfer.ui.mainscreens.FavouriteScreen
import com.example.speedotransfer.ui.mainscreens.HomeScreen
import com.example.speedotransfer.ui.mainscreens.MoreScreen
import com.example.speedotransfer.ui.notifications.NotificationsScreen
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
fun MainScreensGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    logout: () -> Unit
) {

    NavHost(navController = navController, startDestination = Route.HOME, route = Route.MAINAPP) {

        composable(
            route = "${Route.HOME}/{customerName}/{currentBalance}/{accountNumber}",
            arguments = listOf(
                navArgument("customerName") { type = NavType.StringType },
                navArgument("currentBalance") { type = NavType.StringType },
                navArgument("accountNumber") { type = NavType.StringType })

        ) {
            val customerName = it.arguments?.getString("customerName")!!
            val currentBalance = it.arguments?.getString("currentBalance")!!
            val accountNumber = it.arguments?.getString("accountNumber")!!
            HomeScreen(navController, customerName, currentBalance,accountNumber)
        }
        composable(route = "${Route.MORE}/{accountNumber}",
           arguments = listOf( navArgument("accountNumber") { type = NavType.StringType }))
             {

            val accountNumber = it.arguments?.getString("accountNumber")!!
                 MoreScreen(navController,accountNumber, logout = logout) }
        composable(route = Route.NOTIFICATIONS) { NotificationsScreen(navController) }
        composable(route = "${Route.AMONT}/{customerAccountNumber}",
            arguments = listOf(navArgument("customerAccountNumber") { type = NavType.StringType })) {
            val customerAccountNumber = it.arguments?.getString("customerAccountNumber")!!
            AmontScreen(navController,customerAccountNumber) }
        composable(
            route = "${Route.CONFIRMATION}/{amountSent}/{recipientName}/{recipientAccount}/{customerAccountNumber}",
            arguments = listOf(
                navArgument("amountSent") { type = NavType.StringType },
                navArgument("recipientName") { type = NavType.StringType },
                navArgument("recipientAccount") { type = NavType.StringType },
                navArgument("customerAccountNumber") { type = NavType.StringType })
        ) {
            val amountSent = it.arguments?.getString("amountSent")!!
            val recipientName = it.arguments?.getString("recipientName")!!
            val recipientAccount = it.arguments?.getString("recipientAccount")!!
            val customerAccountNumber = it.arguments?.getString("customerAccountNumber")!!
            ConfirmationScreen(navController, amountSent, recipientName, recipientAccount, customerAccountNumber)
        }

        composable(
            route = "${Route.PAYMENT}/{amountSent}/{recipientName}/{recipientAccount}/{customerAccountNumber}",
            arguments = listOf(
                navArgument("amountSent") { type = NavType.StringType },
                navArgument("recipientName") { type = NavType.StringType },
                navArgument("recipientAccount") { type = NavType.StringType },
                navArgument("customerAccountNumber") { type = NavType.StringType })


        ) {
            val amountSent = it.arguments?.getString("amountSent")!!
            val recipientName = it.arguments?.getString("recipientName")!!
            val recipientAccount = it.arguments?.getString("recipientAccount")!!
            val customerAccountNumber = it.arguments?.getString("customerAccountNumber")!!
            PaymentScreen(navController, amountSent, recipientName, recipientAccount, customerAccountNumber)
        }
        composable(route = "${Route.TRANSACTIONS}/{accountNumber}",
            arguments = listOf(navArgument("accountNumber") { type = NavType.StringType }))
        {
            val accountNumber = it.arguments?.getString("accountNumber")!!
            TransactionHistory(navController,accountNumber) }
        composable(
            route = "${Route.TRASACTIONDETAILS}/{amount}/{senderName}/{senderAccountNumber}/{receiverName}/{receiverAccountNumber}/{date}",
            arguments = listOf(navArgument("amount") { type = NavType.StringType },
                navArgument("senderName") { type = NavType.StringType },
                navArgument("senderAccountNumber") { type = NavType.StringType },
                navArgument("receiverName") { type = NavType.StringType },
                navArgument("receiverAccountNumber") { type = NavType.StringType },
                navArgument("date") { type = NavType.StringType })
        ) {
            val amount = it.arguments?.getString("amount")!!
            val senderName = it.arguments?.getString("senderName")!!
            val senderAccountNumber = it.arguments?.getString("senderAccountNumber")!!
            val receiverName = it.arguments?.getString("receiverName")!!
            val receiverAccountNumber = it.arguments?.getString("receiverAccountNumber")!!
            val date = it.arguments?.getString("date")!!
            TransactionDetailsScreen(
                navController,
                amount,
                senderName,
                senderAccountNumber,
                receiverName,
                receiverAccountNumber,
                date
            )
        }
        composable(route = "${Route.FAVOURITES}/{accountNumber}",
            arguments = listOf(navArgument("accountNumber") { type = NavType.StringType }))
         {
            val accountNumber = it.arguments?.getString("accountNumber")!!
            FavouriteScreen(navController,accountNumber) }
        composable(route = Route.PROFILE) { ProfileScreen(navController) }
        composable(route = Route.SETTINGS) { SettingsScreen(navController) }
        composable(route = Route.PROFILEINFORMATION) { ProfileInformationScreen(navController) }
        composable(route = Route.EDITPROFILE) { EditProfileScreen(navController) }
        composable(route = Route.CHANGEPASSWORD) { ChangePasswordScreen(navController) }
    }
}