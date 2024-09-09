package com.example.speedotransfer.ui.transferscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.speedotransfer.R
import com.example.speedotransfer.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G30
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.G90
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.S400

@Composable
fun PaymentScreen(navController: NavHostController, modifier: Modifier = Modifier) {
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
        Row(modifier = modifier.fillMaxWidth()) {
            IconButton(onClick = { navController.navigate(Route.CONFIRMATION) }) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "back button",
                    modifier = modifier.size(24.dp)
                )

            }
            Text(
                text = "Transfer", modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp)
                    .align(Alignment.CenterVertically), style = AppTypography.titleMedium
            )

        }
        Image(painter = painterResource(id = R.drawable.stepper_horizontal_3), contentDescription =""
            , modifier = modifier
                .padding(vertical = 20.dp)
                .size(width = 370.dp, height = 40.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(text = "Amount", style = AppTypography.bodyMedium)
            Text(
                text = "Confirmation",
                modifier = modifier.padding(start = 65.dp),
                style = AppTypography.bodyMedium
            )
            Text(
                text = "Payment",
                modifier = modifier.padding(start = 60.dp),
                style = AppTypography.bodyMedium

            )

        }
        Image(painter = painterResource(id = R.drawable.group_16) , contentDescription =""
        ,modifier= modifier
                .size(130.dp)
                .padding(top = 20.dp))

        Text(
            text = "Your transfer was successful", modifier = modifier
                .padding(vertical = 20.dp)
            , style = AppTypography.titleSemiBold
        )
        Box(modifier=modifier.fillMaxSize().padding(horizontal = 16.dp)){
        Column {
            Card(
                modifier = modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(), colors = CardDefaults.cardColors(
                    G30
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
                    G30
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


        Row(modifier = modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 20.dp)){
            Text(text="Transfer amount", color = G90)
            Text(text="1000 EGP", color = G90, modifier = modifier.padding(start = 200.dp))

        }
        HorizontalDivider(
            color = Color.LightGray,
            thickness = 2.dp,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        )
        Button(
            onClick = {navController.navigate(Route.HOME) }, modifier = modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp)
                .height(50.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(P300)
        ) {
            Text(text = "Back to Home ", style = AppTypography.button)
        }
        TextButton(onClick = { navController.navigate(Route.AMONT) },modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 12.dp, end = 12.dp)
            .height(50.dp), border = BorderStroke(1.dp, P300),
            shape = RoundedCornerShape(4.dp),
        ) {
            Text(text = "Add to Favourite ", style = AppTypography.button, color = P300)

        }
    }
}

