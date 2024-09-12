package com.example.speedotransfer.ui.mainscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.navigation.Route
import com.example.speedotransfer.ui.profile.InitialsIcon
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G300
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P400

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val name = "Asmaa Dosuky"
    val currentBalance = "100000EGP"
    val recentTransactions =
        listOf("Ahmed Mohamed", "Visa. Master Card. 1234", "Today 11:00", "500EGP")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Home, Login
                    )
                )
            )
    ) {
        Box {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp,vertical = 16.dp)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Box(
                            modifier = modifier
                                .size(48.dp)
                                .background(color = G40, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            InitialsIcon(name)
                        }
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = modifier
                                .padding(start = 8.dp)
                                .height(48.dp)
                        ) {
                            Text(
                                text = "Welcome back,",
                                color = P300,
                            )
                            Text(
                                text = "Asmaa Dosuky",
                                style = AppTypography.titleSemiBold,
                            )


                        }
                    }
                    Image(painter = painterResource(id = R.drawable.notifications),
                        contentDescription = "notifications",
                        modifier = modifier
                            .size(32.dp)
                            .padding(end = 0.dp)
                            .clickable {
                                navController.navigate(Route.NOTIFICATIONS)
                            })

                }
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(123.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        P300
                    )
                ) {
                    Text(
                        text = "Current Balance",
                        color = G0,
                        modifier = modifier.padding(start = 23.dp, top = 24.dp)
                    )
                    Text(
                        text = currentBalance,
                        color = G0,
                        modifier = modifier.padding(start = 23.dp, top = 16.dp),
                        style = AppTypography.h3
                    )


                }
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        textAlign = TextAlign.Start,
                        text = "Recent Transactions",
                        modifier = modifier.align(Alignment.CenterVertically),
                        style = AppTypography.bodyLarge
                    )

                    TextButton(onClick = { navController.navigate(Route.TRANSACTIONS) }) {

                        Text(
                            textAlign = TextAlign.End,
                            text = "View all",
                            style = AppTypography.bodyLarge,
                            color = G200,
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(end = 0.dp)
                        )

                    }

                }

            }
        }
        RecentTransactions(name = name, date = recentTransactions[2], amount = "500", status = "Received" )


    }
}

@Composable
fun RecentTransactions(name: String, date: String, amount: String, status:String, modifier: Modifier = Modifier) {

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 60.dp)
            .background(color = G0)
    ) {

        items(20) {
            Row(modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 16.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bank_card),
                    contentDescription = "",
                    modifier = modifier.size(height = 61.dp, width = 64.dp)

                )

                Column(modifier = modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp, top = 4.dp)
                ) {

                    Text(text = name, style = AppTypography.bodyLarge)
                    Text(
                        text = "Visa. Master Card. 1234",
                        style = AppTypography.bodySmall,
                        color = G300,
                        modifier = modifier
                    )
                    Text(
                        text = "$date - $status",
                        style = AppTypography.bodySmall,
                        color = G100,
                        modifier = modifier.padding()
                    )


                }
                Text(text = "${amount}EGP", style = AppTypography.bodyLarge, color = P300, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)

            }
            HorizontalDivider(
                thickness = 1.dp,
                color = G40,
            )
        }
    }


}


@Preview
@Composable
private fun homescreenprev() {
    HomeScreen(navController = rememberNavController())
}
