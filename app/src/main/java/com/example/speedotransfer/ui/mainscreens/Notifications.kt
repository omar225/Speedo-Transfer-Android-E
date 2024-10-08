package com.example.speedotransfer.ui.mainscreens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G700
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P50
import com.example.speedotransfer.ui.theme.P75

@Composable
fun NotificationsScreen(navController: NavHostController, modifier: Modifier = Modifier) {
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
        Spacer(modifier = modifier.height(40.dp))
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)) {
                IconButton(onClick = { navController.navigate(Route.HOME)}) {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp)
                    )

                }
                Text(
                    text = "Notifications",
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(end = 20.dp),
                    style = AppTypography.titleMedium,
                    textAlign = TextAlign.Center
                )

            }
            NotificationCard(moneyReceived = "1000", date = "12 Jul 2024", time = "09:00 PM", name = "Asmaa Dosuky")
            NotificationCard(moneyReceived = "1000", date = "12 Jul 2024", time = "09:00 PM", name = "Asmaa Dosuky")
            NotificationCard(moneyReceived = "1000", date = "12 Jul 2024", time = "09:00 PM", name = "Asmaa Dosuky")
        }
    }

}


@Composable
fun NotificationCard(moneyReceived: String, date: String, time: String, name: String, modifier: Modifier = Modifier) {

    Card(
        colors = CardDefaults.cardColors(
            P50
        ),modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            Card(modifier = modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .background(color = P50)
                .size(54.dp), elevation = CardDefaults.cardElevation(3.dp)){
                Box (modifier = modifier.fillMaxSize(),contentAlignment = Alignment.Center){
                    Image(

                        painter = painterResource(id = R.drawable.received),
                        contentDescription = "",
                        modifier = modifier

                            .size(32.dp)
                            .clip(shape = CircleShape)
                            .background(color = P75),
                        colorFilter = ColorFilter.tint(P300)
                    )
                }
            }

            Column(horizontalAlignment = Alignment.Start, modifier = modifier.padding(vertical = 16.dp)) {

                Text(text = "Received Transactions", style = AppTypography.bodyMedium)
                Text(
                    text = "You have received $moneyReceived USD from $name 1234xxxx",
                    style = AppTypography.bodyLarge,
                    textAlign = TextAlign.Start,
                    color = G700
                )
                Text(
                    text = "$date $time ",
                    style = AppTypography.bodyLarge,
                    color = G100,
                    textAlign = TextAlign.Start
                )


            }
        }






    }

}


@Preview
@Composable
private fun NotificationScreenPreview() {

    NotificationsScreen(navController = rememberNavController())
}