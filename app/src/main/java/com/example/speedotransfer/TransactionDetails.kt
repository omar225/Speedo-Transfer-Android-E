package com.example.speedotransfer


import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G30
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.S400

@Composable
fun TransactionDetailsScreen(modifier: Modifier = Modifier) {
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "back button",
                    modifier = modifier.size(24.dp)
                )

            }
            Text(
                text = "Successful Transaction", modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically), style = AppTypography.titleMedium
            )

        }


        Image(
            painter = painterResource(id = R.drawable.group_18305),
            contentDescription = "",
            modifier = modifier.size(130.dp).padding(top = 20.dp)
        )

        Text(
            text = "1000", modifier = modifier
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
        Card(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(), colors = CardDefaults.cardColors(
                G30
            )
        ) {
            Row(modifier = modifier.fillMaxWidth()) {

                Image(
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.bank),
                    contentDescription = "",
                    modifier = modifier.padding(start = 20.dp).align(Alignment.CenterVertically)
                        .size(40.dp).clip(shape = CircleShape)
                        .background(color = G40)
                )

                Column(modifier = modifier.padding(start = 40.dp)) {
                    Text(
                        text = "From",
                        style = AppTypography.bodySmall,
                        color = P300,
                        modifier = modifier.padding(vertical = 16.dp)
                    )
                    Text(text = "Asmaa Dosuky", style = AppTypography.titleSemiBold,)
                    Text(
                        text = "Account xxxx7890",
                        style = AppTypography.bodySmall,
                        color = G100,
                        modifier = modifier.padding(vertical = 16.dp)
                    )


                }
            }

        }
        Image(
            painter = painterResource(id = R.drawable.group_18305),
            contentDescription = "",
            modifier = modifier.size(40.dp).clip(shape = CircleShape).background(color = S400)
        )

        Card(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(), colors = CardDefaults.cardColors(
                G30
            )
        ) {
            Row(modifier = modifier.fillMaxWidth()) {

                Image(
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.bank),
                    contentDescription = "",
                    modifier = modifier.padding(start = 20.dp).align(Alignment.CenterVertically)
                        .size(40.dp).clip(shape = CircleShape)
                        .background(color = G40)
                )

                Column(modifier = modifier.padding(start = 40.dp)) {
                    Text(
                        text = "To",
                        style = AppTypography.bodySmall,
                        color = P300,
                        modifier = modifier.padding(vertical = 16.dp)
                    )
                    Text(text = "Jonathon Smith", style = AppTypography.titleSemiBold,)
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
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxWidth(), colors = CardDefaults.cardColors(
                G30
            )
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                    Text(
                        text = "Reference",
                        style = AppTypography.bodySmall,
                        color = G100,
                        modifier = modifier.padding(vertical = 16.dp)
                    )
                    Text(
                        text = "123456789876",
                        style = AppTypography.bodySmall,
                        color = G100,
                        modifier = modifier.padding(vertical = 16.dp).fillMaxWidth(),
                        textAlign = TextAlign.End

                    )


                }
            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "Date",
                    style = AppTypography.bodySmall,
                    color = G100,
                    modifier = modifier.padding(vertical = 16.dp)
                )
                Text(
                    text = "20 Jul 2024 7:50 PM",
                    style = AppTypography.bodySmall,
                    color = G100,
                    modifier = modifier.padding(vertical = 16.dp).fillMaxWidth(),
                    textAlign = TextAlign.End
                )


            }
            }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun TransactionDetailsScreenPreview() {
    TransactionDetailsScreen()
}