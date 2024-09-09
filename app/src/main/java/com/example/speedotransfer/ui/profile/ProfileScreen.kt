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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.G900
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P50

@Composable
fun ProfileScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val name = "Asmaa Dosuky"
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
                IconButton (onClick = {navController.navigate(Route.MORE)}){
                    Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "back icon",
                    tint = G900,
                    modifier = modifier
                        .clickable { }
                        .size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Profile",
                    style = AppTypography.titleMedium,
                    color = G900,
                )

                Spacer(modifier = Modifier.weight(1f))

            }

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                InitialsIcon(name = name)
                Text(
                    text = name,
                    style = AppTypography.titleSemiBold,
                    color = G900,
                    modifier = modifier.padding(start = 16.dp)
                )

            }
            Spacer(modifier = Modifier.padding(top = 16.dp))

            OptionsItems(navController,
                destination = Route.PROFILEINFORMATION,
                leadingIcon = R.drawable.user,
                title = "Personal Information",
                description = "Your Information"
            ) {}


            OptionsItems(navController,
                destination = Route.SETTINGS,
                leadingIcon = R.drawable.setting,
                title = "Setting",
                description = "Change your settings"
            ) {}

            OptionsItems(navController,
                destination = Route.TRANSACTIONS,
                leadingIcon = R.drawable.history_1,
                title = "Payment history",
                description = "View your transactions"
            ) {}


            OptionsItems(navController,
                destination = Route.FAVOURITES,
                leadingIcon = R.drawable.favorite,
                title = "My Favourite list",
                description = "View your favourites"
            ) {}

        }
    }

}

@Composable
fun InitialsIcon(name: String) {
    val initials = name.split(" ")
        .mapNotNull { it.firstOrNull()?.toString() }
        .take(2)
        .joinToString("")

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(48.dp) // Setting the size of the icon
            .clip(CircleShape)
            .background(G40) // Background color for the circle
    ) {
        Text(
            text = initials,
            style = AppTypography.titleSemiBold,
            color = G100,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OptionsItems(navController: NavController,destination: String,
    leadingIcon: Int,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(P50)
        ) {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(24.dp)
                    .fillMaxSize(),
                tint = P300 // Change color as needed
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = title,
                style = AppTypography.bodyMedium,
                color = G900
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = AppTypography.bodyLarge,
                color = G100
            )
        }

        IconButton(onClick ={navController.navigate(destination) }){
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "next",
                modifier = Modifier
                    .size(24.dp),
                tint = G200

            )
        }

    }

    HorizontalDivider(
        thickness = 1.dp,
        color = G40,
    )
}


@Preview(showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}