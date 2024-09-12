package com.example.speedotransfer.ui.onboardingscreens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G400
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300

@Composable
fun OnBoardingScreenOne(navController: NavController, modifier: Modifier = Modifier) {
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
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(
                onClick = { navController.navigate(Route.SIGNUP) }, modifier = modifier
                    .align(Alignment.End)
                    .padding(top = 40.dp)
            ) {
                Text(text = "Skip", textAlign = TextAlign.End, color = G400)

            }
            Image(
                painter = painterResource(id = R.drawable.amont),
                contentDescription = "",
                modifier = modifier.size(360.dp)
            )
            OnboardingScreenDots(page = 1)
            Text(text = "Amount", style = AppTypography.h3)
            Text(
                text = "Send money fast with simple steps. Create account, Configuration, Payment, Simple",
                textAlign = TextAlign.Center,
                modifier = modifier.padding(16.dp)
            )
            Button(
                onClick = { navController.navigate(Route.ONBOARDINGSCREEN2) }, modifier = modifier
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
fun OnBoardingScreenTwo(navController: NavController, modifier: Modifier = Modifier) {
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
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(
                onClick = { navController.navigate(Route.SIGNUP) }, modifier = modifier
                    .align(Alignment.End)
                    .padding(top = 40.dp)
            ) {
                Text(text = "Skip", textAlign = TextAlign.End, color = G400)

            }
            Image(
                painter = painterResource(id = R.drawable.confirmation),
                contentDescription = "",
                modifier = modifier.size(360.dp)
            )
            OnboardingScreenDots(page = 2)
            Text(text = "Confirmation", style = AppTypography.h3)
            Text(
                text = "Transfer funds instantly to friends and family worldwide, strong shield protecting a money",
                textAlign = TextAlign.Center,
                modifier = modifier.padding(16.dp)
            )
            Button(
                onClick = { navController.navigate(Route.ONBOARDINGSCREEN3) }, modifier = modifier
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
fun OnBoardingScreenThree(navController: NavController, modifier: Modifier = Modifier) {
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
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(
                onClick = { navController.navigate(Route.SIGNUP) }, modifier = modifier
                    .align(Alignment.End)
                    .padding(top = 40.dp)
            ) {
                Text(text = "Skip", textAlign = TextAlign.End, color = G400)

            }
            Image(
                painter = painterResource(id = R.drawable.payment),
                contentDescription = "",
                modifier = modifier.size(360.dp)
            )
            OnboardingScreenDots(page = 3)
            Text(text = "Payment", style = AppTypography.h3)
            Text(
                text = "Enjoy peace of mind with our secure platform Transfer funds instantly to friends.",
                textAlign = TextAlign.Center,
                modifier = modifier.padding(16.dp)
            )
            Button(
                onClick = { navController.navigate(Route.SIGNUP) }, modifier = modifier
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
fun OnboardingScreenDots(page: Int, modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(top = 16.dp, bottom = 24.dp)
            .fillMaxWidth()
    ) {


    if (page == 1) {

        Image(painter = painterResource(id = R.drawable.bold_dot), contentDescription = "bold")
        Spacer(modifier = modifier.size(8.dp))
        Image(painter = painterResource(id = R.drawable.normal_dot), contentDescription = "bold")
        Spacer(modifier = modifier.size(8.dp))
        Image(painter = painterResource(id = R.drawable.normal_dot), contentDescription = "bold")
    }

    else if (page == 2) {

        Image(painter = painterResource(id = R.drawable.normal_dot), contentDescription = "bold")
        Spacer(modifier = modifier.size(8.dp))
        Image(painter = painterResource(id = R.drawable.bold_dot), contentDescription = "bold")
        Spacer(modifier = modifier.size(8.dp))
        Image(painter = painterResource(id = R.drawable.normal_dot), contentDescription = "bold")

    }

    else {

        Image(painter = painterResource(id = R.drawable.normal_dot), contentDescription = "bold")
        Spacer(modifier = modifier.size(8.dp))
        Image(painter = painterResource(id = R.drawable.normal_dot), contentDescription = "bold")
        Spacer(modifier = modifier.size(8.dp))
        Image(painter = painterResource(id = R.drawable.bold_dot), contentDescription = "bold")

    }
}
}

@Preview
@Composable
private fun OnboardingScreenOnepreview() {
    OnBoardingScreenOne(navController = rememberNavController())

}