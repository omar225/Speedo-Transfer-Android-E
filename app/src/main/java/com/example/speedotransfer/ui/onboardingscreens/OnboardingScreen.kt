package com.example.speedotransfer.ui.onboardingscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G400
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300

@Composable
fun OnBoardingScreenOne(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        G0,
                        Login
                    )
                )
            ), contentAlignment = Alignment.Center){
        Column(modifier = modifier
            .fillMaxSize().padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(onClick = { /*TODO*/ },modifier = modifier
                .align(Alignment.End)) {
                Text(text = "Skip", textAlign = TextAlign.End, color = G400)

            }
            Image(painter = painterResource(id = R.drawable.amont), contentDescription ="" ,modifier=modifier.size(360.dp))
            Text(text = "Amont", style = AppTypography.h3)
            Text(text = "Send money fast with simple steps. Create account, Configuration, Payment, Simple", textAlign = TextAlign.Center, modifier = modifier.padding(16.dp))
            Button(
                onClick = { }, modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Next ", style = AppTypography.button)
            }
        }

    }
}
@Composable
fun OnBoardingScreenTwo(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        G0,
                        Login
                    )
                )
            ), contentAlignment = Alignment.Center){
        Column(modifier = modifier
            .fillMaxSize().padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(onClick = { /*TODO*/ },modifier = modifier
                .align(Alignment.End)) {
                Text(text = "Skip", textAlign = TextAlign.End, color = G400)

            }
            Image(painter = painterResource(id = R.drawable.confirmation), contentDescription ="" ,modifier=modifier.size(360.dp))
            Text(text = "Confirmation", style = AppTypography.h3)
            Text(text = "Transfer funds instantly to friends and family worldwide, strong shield protecting a money", textAlign = TextAlign.Center, modifier = modifier.padding(16.dp))
            Button(
                onClick = { }, modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Next ", style = AppTypography.button)
            }
        }

    }

}
@Composable
fun OnBoardingScreenThree(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        G0,
                        Login
                    )
                )
            ), contentAlignment = Alignment.Center){
        Column(modifier = modifier
            .fillMaxSize().padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(onClick = { /*TODO*/ },modifier = modifier
                .align(Alignment.End)) {
                Text(text = "Skip", textAlign = TextAlign.End, color = G400)

            }
            Image(painter = painterResource(id = R.drawable.payment), contentDescription ="" ,modifier=modifier.size(360.dp))
            Text(text = "Payment", style = AppTypography.h3)
            Text(text = "Enjoy peace of mind with our secure platform Transfer funds instantly to friends.", textAlign = TextAlign.Center, modifier = modifier.padding(16.dp))
            Button(
                onClick = { }, modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Next ", style = AppTypography.button)
            }
        }

    }

}