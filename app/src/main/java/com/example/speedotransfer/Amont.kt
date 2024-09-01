package com.example.speedotransfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G300
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300

@Composable
fun AmontScreen(modifier: Modifier = Modifier) {
    var amountSent by rememberSaveable {
        mutableStateOf("")
    }
    var amountReceived by rememberSaveable {
        mutableStateOf("")
    }
    var recipientName by rememberSaveable {
        mutableStateOf("")
    }
    var recipientAccount by rememberSaveable {
        mutableStateOf("")
    }

    Column(

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
                text = "Transfer", modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp)
                    .align(Alignment.CenterVertically), style = AppTypography.titleMedium
            )

        }
        Image(painter = painterResource(id = R.drawable.stepper_horizontal_1), contentDescription =""
            , modifier = modifier
                .padding(top = 20.dp, bottom = 20.dp, start = 10.dp)
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
        Text(
            text = "How much are you sending?",
            modifier = modifier.padding(top = 32.dp, start = 12.dp),
            style = AppTypography.titleSemiBold
        )
        Text(
            text = "Choose Currency",
            modifier = modifier.padding(top = 32.dp, start = 12.dp, bottom = 20.dp),
            style = AppTypography.bodyMedium,
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Text(
                text = "1 USD = 48.42.4220 EGP",
                modifier = modifier.padding(top = 12.dp, start = 12.dp),
                style = AppTypography.bodyMedium
            )

            Text(
                text = "Rate guaranteed (2h)",
                modifier = modifier.padding(top = 12.dp, start = 12.dp),
                style = AppTypography.bodyMedium,
                color = G100
            )
            Text(
                text = "You Send",
                modifier = modifier.padding(top = 12.dp, start = 12.dp),
                style = AppTypography.bodyMedium,
                color = G300
            )
            Row(modifier = modifier.padding(top = 16.dp)) {
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Image(painter = painterResource(id = R.drawable.chevron_down) , contentDescription ="", modifier = modifier.size(30.dp) )

                }
                OutlinedTextField(
                    colors = TextFieldDefaults.colors(focusedContainerColor = G0, unfocusedContainerColor = G0),
                    value = amountSent,
                    onValueChange = { amountSent = it },
                    shape = RoundedCornerShape(4.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = modifier
                        .fillMaxWidth()
                        .size(150.dp, 50.dp)
                        .padding(start = 50.dp)
                )
            }
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 2.dp,
                modifier = modifier.padding(horizontal = 16.dp, vertical = 20.dp)
            )

            Text(
                text = "Recipient Gets",
                modifier = modifier.padding( start = 12.dp),
                style = AppTypography.bodyMedium,
                color = G300
            )
            Row(modifier = modifier.padding(vertical = 16.dp)) {
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Image(painter = painterResource(id = R.drawable.chevron_down) , contentDescription ="", modifier = modifier.size(30.dp) )

                }
                OutlinedTextField(
                    colors = TextFieldDefaults.colors(focusedContainerColor = G0, unfocusedContainerColor = G0),
                    value = amountReceived,
                    onValueChange = { amountReceived = it },
                    shape = RoundedCornerShape(4.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = modifier
                        .fillMaxWidth()
                        .size(150.dp, 50.dp)
                        .padding(start = 50.dp)
                )
            }

        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Text(text = "Recipient Information", modifier = modifier.align(Alignment.CenterVertically), style = AppTypography.bodyLarge)

            TextButton(onClick = {},modifier = modifier.padding(start = 70.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = "",
                    modifier = modifier
                        .size(20.dp),
                    tint = P300
                )
                Text(
                    text = "Favourite",
                    modifier = modifier.padding(start = 8.dp),
                    style = AppTypography.bodyLarge,
                    color = P300
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = "",
                    modifier = modifier
                        .padding(start = 4.dp)
                        .size(14.dp)
                        .align(Alignment.CenterVertically),
                    tint = P300
                )
            }

        }
        Text(
            text = "Recipient Name",
            modifier = modifier.padding(top = 12.dp, start = 12.dp),
            style = AppTypography.bodyLarge,
            color = G100
        )
        OutlinedTextField(
            value = recipientName,
            onValueChange = { recipientName = it },
            label = { Text(text = "Enter Recipient Name")},
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp),
            textStyle = TextStyle(color = G100),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = G0,
                unfocusedContainerColor = G0
            )
        )
        Text(
            text = "Recipient Account",
            modifier = modifier.padding(start = 12.dp),
            style = AppTypography.bodyLarge,
            color = G100
        )
        OutlinedTextField(
            value = recipientAccount,
            onValueChange = { recipientAccount = it },
            label = { Text(text = "Enter Recipient Account Number")},
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp),
            textStyle = TextStyle(color = G100),
            shape = RoundedCornerShape(4.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = G0,
                unfocusedContainerColor = G0
            )
        )

        Button(
            onClick = { }, modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .height(50.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(P300)
        ) {
            Text(text = "Continue ", style = AppTypography.button)
        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Amont() {
    AmontScreen()
}