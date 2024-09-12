package com.example.speedotransfer.ui.transaction


import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G30
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.G700
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P50
import com.example.speedotransfer.ui.theme.S400

@Composable
fun TransactionDetailsScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = ScrollState(5), enabled = true)
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Home, Login
                    )
                )
            )
    ) {
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
                onClick = { navController.navigate(Route.TRANSACTIONS) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "back button",
                    modifier = modifier.size(24.dp)
                )

            }
            Text(
                text = "Successful Transactions",
                style = AppTypography.titleMedium,
                modifier = modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }
        Image(
            painter = painterResource(id = R.drawable.group_18305),
            contentDescription = "",
            modifier = modifier
                .size(130.dp)
                .padding(top = 20.dp)
        )

        Text(
            text = "1000 EGP", modifier = modifier
                .padding(top = 20.dp, bottom = 10.dp), style = AppTypography.titleSemiBold
        )
        Text(
            text = "Transfer amount", modifier = modifier
                .padding(bottom = 10.dp), style = AppTypography.bodyLarge, color = G200
        )
        Text(
            text = "Send money", modifier = modifier
                .padding(bottom = 20.dp), style = AppTypography.bodyLarge, color = P300
        )
        Box(modifier= modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)){
            Column {
                Card(
                    modifier = modifier
                        .padding(vertical = 5.dp)
                        .fillMaxWidth(), colors = CardDefaults.cardColors(
                        P50
                    )
                ) {
                    Row(modifier = modifier.fillMaxWidth()) {

                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.bank),
                            contentDescription = "",
                            modifier = modifier
                                .padding(start = 20.dp)
                                .align(Alignment.CenterVertically)
                                .size(40.dp)
                                .clip(shape = CircleShape)
                                .background(color = G40)
                        )

                        Column(modifier = modifier.padding(start = 40.dp)) {
                            Text(
                                text = "From",
                                style = AppTypography.bodySmall,
                                color = P300,
                                modifier = modifier.padding(vertical = 16.dp)
                            )
                            Text(text = "Asmaa Dosuky", style = AppTypography.titleSemiBold)
                            Text(
                                text = "Account xxxx7890",
                                style = AppTypography.bodySmall,
                                color = G100,
                                modifier = modifier.padding(vertical = 16.dp)
                            )


                        }
                    }

                }

                Card(
                    modifier = modifier
                        .padding(vertical = 5.dp)
                        .fillMaxWidth(), colors = CardDefaults.cardColors(
                        P50
                    )
                ) {
                    Row(modifier = modifier.fillMaxWidth()) {

                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.bank),
                            contentDescription = "",
                            modifier = modifier
                                .padding(start = 20.dp)
                                .align(Alignment.CenterVertically)
                                .size(40.dp)
                                .clip(shape = CircleShape)
                                .background(color = G40)
                        )

                        Column(modifier = modifier.padding(start = 40.dp)) {
                            Text(
                                text = "To",
                                style = AppTypography.bodySmall,
                                color = P300,
                                modifier = modifier.padding(vertical = 16.dp)
                            )
                            Text(text = "Jonathon Smith", style = AppTypography.titleSemiBold)
                            Text(
                                text = "Account xxxx7890",
                                style = AppTypography.bodySmall,
                                color = G100,
                                modifier = modifier.padding(vertical = 16.dp)
                            )


                        }
                    }

                }
            }
            Image(
                painter = painterResource(id = R.drawable.group_18305),
                contentDescription = "",
                modifier = modifier
                    .align(Alignment.Center)
                    .size(40.dp)
                    .clip(shape = CircleShape)
                    .background(color = S400)
            )
        }

        Card(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxWidth(), colors = CardDefaults.cardColors(
                P50
            )
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "Transfer Amount",
                    style = AppTypography.bodySmall,
                    color = G700,
                    modifier = modifier.padding(vertical = 16.dp)
                )
                Text(
                    text = "1000EGP",
                    style = AppTypography.bodySmall,
                    color = G100,
                    modifier = modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )

            }

            HorizontalDivider(
                color = G40,
                thickness = 1.dp,
            )

            Row(modifier = modifier.fillMaxWidth()) {
                    Text(
                        text = "Reference",
                        style = AppTypography.bodySmall,
                        color = G700,
                        modifier = modifier.padding(vertical = 16.dp)
                    )
                    Text(
                        text = "123456789876",
                        style = AppTypography.bodySmall,
                        color = G100,
                        modifier = modifier
                            .padding(vertical = 16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.End

                    )


                }
            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "Date",
                    style = AppTypography.bodySmall,
                    color = G700,
                    modifier = modifier.padding(vertical = 16.dp)
                )
                Text(
                    text = "20 Jul 2024 7:50 PM",
                    style = AppTypography.bodySmall,
                    color = G100,
                    modifier = modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )


            }
            }

        Spacer(modifier = modifier.height(58.dp))
    }
}

@Preview
@Composable
private fun TransactionDetailsScreenPreview() {
    TransactionDetailsScreen(navController = rememberNavController())
}

