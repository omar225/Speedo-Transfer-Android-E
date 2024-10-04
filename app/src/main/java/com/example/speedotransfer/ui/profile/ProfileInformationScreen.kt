package com.example.speedotransfer.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.G900
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login

@Composable
fun ProfileInformationScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val name = "Abdelrahman Ashraf"
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.padding(top = 36.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp, 0.dp, 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "back icon",
                    tint = G900,
                    modifier = modifier
                        .clickable {navController.popBackStack() }
                        .size(24.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Profile Information",
                    style = AppTypography.titleMedium,
                    color = G900,
                )

                Spacer(modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            ProfileInfoItems(
                title = "Full Name",
                description = name
            )

            ProfileInfoItems(
                title = "Email",
                description = "Abdelrahman@gmail.com"
            )

            ProfileInfoItems(
                title = "Date of Birth",
                description = "12/01/2000"
            )
            
            ProfileInfoItems(
                title = "Country",
                description = "Egypt"
            )

            ProfileInfoItems(
                title = "Bank Account",
                description = "1234xxxx"
            )


        }
    }

}

@Composable
fun ProfileInfoItems(
    title: String,
    description: String,
) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text(
                text = title,
                style = AppTypography.bodyMedium,
                color = G900
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = AppTypography.bodyLarge,
                color = G100
            )
        }

    HorizontalDivider(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        thickness = 1.dp,
        color = G40,
    )

    }

@Preview
@Composable
private fun ProfileInformationPreview() {
    ProfileInformationScreen(rememberNavController())
}