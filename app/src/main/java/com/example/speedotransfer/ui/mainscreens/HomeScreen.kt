package com.example.speedotransfer.ui.mainscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.speedotransfer.R
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
fun HomeScreen(modifier: Modifier = Modifier) {
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
                    .padding(horizontal = 16.dp)
            ) {
                Row (modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                    Row{
                        Box(modifier = modifier
                            .size(48.dp)
                            .background(color = G40, shape = CircleShape),
                            contentAlignment = Alignment.Center) {
                            Text(
                                text = "AD",
                                style = AppTypography.h3,
                                color = G300,

                            )
                        }
                        Column {
                            Text(
                                text = "Welccom back,",
                                color = P300,
                                modifier = modifier.padding(start = 4.dp)
                            )
                            Text(
                                text = "Asmaa Dosuky",
                                style = AppTypography.titleSemiBold,
                                modifier = modifier.padding(top = 12.dp)
                            )


                        }
                    }
                    Image(painter = painterResource(id = R.drawable.notifications), contentDescription ="notifications", modifier= modifier
                        .size(32.dp)
                        .padding(end = 0.dp) )

                }
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(123.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        P400
                    )
                ) {
                    Text(
                        text = "Current Balance",
                        color = G0,
                        modifier = modifier.padding(start = 23.dp, top = 24.dp)
                    )
                    Text(
                        text = "100000EGP",
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

                    TextButton(onClick = {}) {

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


        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
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
                    Text(text = "500EGP", style = AppTypography.bodyLarge, color = P300, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)


                }
            }
        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    Scaffold (

    ){innerPadding->
        HomeScreen(modifier = Modifier.padding(innerPadding))
    }


}