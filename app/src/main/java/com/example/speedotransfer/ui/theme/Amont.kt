package com.example.speedotransfer.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.R

@Composable
fun AmontScreen(modifier: Modifier = Modifier) {





        Box ( modifier = modifier.fillMaxSize().background(brush = Brush.verticalGradient(listOf(
            Home, Login)))){
            Row(modifier=modifier.fillMaxWidth()){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.drop_down), contentDescription ="back button" , modifier = modifier.size(24.dp))

                }
                Text( text = "Transfer",modifier=modifier.fillMaxWidth().padding(start = 100.dp).align(Alignment.CenterVertically), style = AppTypography.titleMedium)

            }
            Row(){

            }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Amont() {
    AmontScreen()
}