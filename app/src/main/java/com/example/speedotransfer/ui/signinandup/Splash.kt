package com.example.speedotransfer.ui.signinandup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.P500
import com.example.speedotransfer.ui.theme.Splash
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController,firstTime:Boolean,modifier: Modifier = Modifier) {
    Box(
        Modifier
            .background(Splash)
            .fillMaxSize()
    ) {
        Text(
            text = "Speedo Transfer ",
            style = AppTypography.h1,
            color = G0,
            modifier = modifier.align(
                Alignment.Center
            )
        )
    }
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(if(firstTime) Route.ONBOARDINGSCREEN else Route.AUTH)
    }

}
