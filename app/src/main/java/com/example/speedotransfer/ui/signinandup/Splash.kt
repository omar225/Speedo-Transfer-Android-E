package com.example.speedotransfer.ui.signinandup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.P500

@Composable
fun Splash(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .background(P500)
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
}
