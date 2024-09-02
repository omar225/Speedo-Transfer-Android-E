package com.example.speedotransfer.ui.errorscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G700
import com.example.speedotransfer.ui.theme.G900
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300

@Composable
fun ErrorConnection(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Home,
                        Login
                    )
                )
            ), contentAlignment = Alignment.Center
    )
    {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.no_internet),
                contentDescription = "Connection Lost",
                modifier
                    .size(110.dp)
            )

            Text(
                text = "Internet connection disabled...",
                style = AppTypography.h3,
                color = G900,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(top = 44.dp)
                    .width(290.dp)
            )

            Button(
                onClick = { },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Update ", style = AppTypography.button)
            }

        }

    }
}


@Composable
fun ErrorServer(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Home,
                        Login
                    )
                )
            ), contentAlignment = Alignment.Center)
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cuate),
                contentDescription = "Connection Lost",
                modifier
                    .size(273.dp, 195.dp)
            )

            Text(
                text = "Server error...",
                style = AppTypography.h3,
                color = G900,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(top = 44.dp)
                    .width(290.dp)
            )

            Text(
                text = "It seems like we’re having some difficulties,"+
                        " please don’t leave your aspirations," +
                        " we are sending for help",
                style = AppTypography.bodyLarge,
                color = G700,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(top = 44.dp)
                    .width(343.dp)
            )

            Button(
                onClick = { },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Call Us", style = AppTypography.button)
            }
            Button(
                onClick = { },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.5.dp,P300),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(
                    text = "Message Us ",
                    style = AppTypography.button,
                    color = P300
                )
            }

        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ErrorConnectionPreview() {
  ErrorServer()
}