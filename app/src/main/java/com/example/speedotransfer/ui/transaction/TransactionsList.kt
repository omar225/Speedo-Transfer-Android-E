package com.example.speedotransfer.ui.transaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.D300
import com.example.speedotransfer.ui.theme.DarkGreen
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G300
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.LightGreen
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P50

@Composable
fun TransactionHistory(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyColumn(
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
        item {
            Spacer(modifier = modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                IconButton(
                    modifier = modifier
                        .size(24.dp),
                    onClick = { navController.navigate(Route.HOME) }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp)
                    )

                }
                Text(
                    text = "Transactions",
                    style = AppTypography.titleMedium,
                    modifier = modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

            }
            Text(
                text = "Your Last Transactions",
                style = AppTypography.titleSemiBold,
                modifier = modifier.padding(top = 30.dp)
            )
        }
        item() {
            Card(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .clickable { navController.navigate(Route.TRASACTIONDETAILS) },
                colors = CardDefaults.cardColors(
                    G0
                )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 12.dp)
                ) {
                    Box(
                        modifier = modifier
                            .padding(start = 12.dp)
                            .size(height = 50.dp, width = 55.dp)
                            .background(color = P50, shape = RoundedCornerShape(4.dp))
                    ) {
                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.card2),
                            contentDescription = "",
                            modifier = modifier
                                .align(Alignment.Center)
                                .size(40.dp), colorFilter = ColorFilter.tint(P300)
                        )
                    }

                    Column(modifier = modifier.padding(start = 16.dp)) {

                        Text(text = "Ahmed Mohamed", style = AppTypography.bodyLarge)
                        Text(
                            text = "Visa. Master Card. 1234",
                            style = AppTypography.bodySmall,
                            color = G300,
                            modifier = modifier
                        )
                        Text(
                            text = "Today 11:00 - Received ",
                            style = AppTypography.bodySmall,
                            color = G100,
                            modifier = modifier.padding()
                        )


                    }
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(end = 12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = "",
                            modifier = modifier
                                .size(16.dp)
                                .align(Alignment.End)
                        )
                        Box(
                            modifier = modifier
                                .padding(top = 16.dp)
                                .align(Alignment.End)
                                .background(
                                    color = LightGreen,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .size(height = 20.dp, width = 80.dp)
                        ) {
                            Text(

                                text = "Successful",
                                modifier = modifier
                                    .align(Alignment.Center),
                                fontSize = 12.sp,
                                color = DarkGreen

                            )
                        }
                    }
                }
                Text(
                    text = "$1000",
                    modifier = modifier.padding(start = 75.dp, top = 12.dp),
                    style = AppTypography.bodyLarge,
                    color = P300
                )

            }
        }
        item {
            Card(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .clickable { },
                colors = CardDefaults.cardColors(
                    G0
                )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 12.dp)
                ) {
                    Box(
                        modifier = modifier
                            .padding(start = 12.dp)
                            .size(height = 50.dp, width = 55.dp)
                            .background(color = P50, shape = RoundedCornerShape(4.dp))
                    ) {
                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.bank),
                            contentDescription = "",
                            modifier = modifier
                                .align(Alignment.Center)
                                .size(40.dp), colorFilter = ColorFilter.tint(P300)
                        )
                    }

                    Column(modifier = modifier.padding(start = 16.dp)) {

                        Text(text = "Ahmed Mohamed", style = AppTypography.bodyLarge)
                        Text(
                            text = "Visa. Master Card. 1234",
                            style = AppTypography.bodySmall,
                            color = G300,
                            modifier = modifier
                        )
                        Text(
                            text = "Today 11:00 - Received ",
                            style = AppTypography.bodySmall,
                            color = G100,
                            modifier = modifier.padding()
                        )


                    }
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(end = 12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = "",
                            modifier = modifier
                                .size(16.dp)
                                .align(Alignment.End)
                        )
                        Box(
                            modifier = modifier
                                .padding(top = 16.dp)
                                .align(Alignment.End)
                                .background(
                                    color = P50,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .size(height = 20.dp, width = 60.dp)
                        ) {
                            Text(

                                text = "Failed",
                                modifier = modifier
                                    .align(Alignment.Center),
                                fontSize = 12.sp,
                                color = D300

                            )
                        }
                    }
                }
                Text(
                    text = "$1000",
                    modifier = modifier.padding(start = 75.dp, top = 12.dp),
                    style = AppTypography.bodyLarge,
                    color = P300
                )

            }
        }

    }
}

@Preview
@Composable
private fun TransactionListPreview() {

    TransactionHistory(navController = rememberNavController())

}


