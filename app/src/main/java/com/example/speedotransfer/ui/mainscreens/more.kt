package com.example.speedotransfer.ui.mainscreens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavHostController, modifier: Modifier = Modifier,logout:()->Unit) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {


            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)) {
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(G0),
                    modifier = modifier.clickable {
                        showBottomSheet=false
                        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto: speedotechsupport@gmail.com"))
                        navController.context.startActivity(emailIntent)
                    }
                )
                {
                    Column(
                        modifier = modifier.size(
                            width = 120.dp, height = 140.dp
                        ), horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = modifier
                                .padding(top = 16.dp)
                                .size(55.dp)
                                .background(color = P50, shape = RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = "",
                                modifier = modifier
                                    .size(24.dp), colorFilter = ColorFilter.tint(P300)
                            )
                        }

                        Text(text = "Send email", modifier = modifier.padding(top = 12.dp))
                    }
                }
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(G0),
                    modifier = modifier.clickable {
                        showBottomSheet=false
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:00000"))
                        navController.context.startActivity(intent)
                    }


                ){
                    Column(
                        modifier = modifier.size(width = 120.dp, height = 140.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = modifier
                                .padding(top = 16.dp)
                                .size(55.dp)
                                .background(color = P50, shape = RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.call),
                                contentDescription = "",
                                modifier = modifier
                                    .size(24.dp), colorFilter = ColorFilter.tint(P300)
                            )
                        }

                        Text(text = "Call us", modifier = modifier.padding(top = 12.dp))
                        Text(text = "00000", color = P300, modifier = modifier.padding(top = 4.dp))
                    }
                }
            }
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Home, Login
                    )
                )
            )
    ) {
        Spacer(modifier = modifier.height(56.dp))
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                IconButton(
                    modifier = modifier.size(24.dp),
                    onClick = { navController.navigate(Route.HOME)}
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp)
                    )

                }
                Text(
                    text = "More",
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically),
                    style = AppTypography.titleMedium,
                    textAlign = TextAlign.Center
                )

            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 52.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier=modifier.align(Alignment.CenterVertically)) {
                    Icon(
                        painter = painterResource(id = R.drawable.website),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp),
                        tint = G200
                    )

                    Text(
                        text = "Transfer From Website",
                        modifier = modifier
                            .padding(start = 28.dp, top = 2.dp),
                        style = AppTypography.bodyLarge,
                        color = G200
                    )
                }
                IconButton(onClick = {  }){
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp),
                        tint = G200,

                        )
                }

            }
            HorizontalDivider(
                color = G40,
                thickness = 2.dp,
                modifier = modifier.padding(vertical = 16.dp)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier=modifier.align(Alignment.CenterVertically)) {
                    Icon(
                        painter = painterResource(id = R.drawable.favorite),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp),
                        tint = G200
                    )

                    Text(
                        text = "Favourites",
                        modifier = modifier
                            .padding(start = 28.dp, top = 2.dp),
                        style = AppTypography.bodyMedium,
                        color = G200
                    )
                }
                IconButton(onClick = { navController.navigate(Route.FAVOURITES) }){
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "Favourites",
                        modifier = modifier.size(24.dp),
                        tint = G200,

                        )
                }

            }
            HorizontalDivider(
                color = G40,
                thickness = 2.dp,
                modifier = modifier.padding(vertical = 16.dp)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier=modifier.align(Alignment.CenterVertically)) {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp),
                        tint = G200
                    )

                    Text(
                        text = "Profile",
                        modifier = modifier
                            .padding(start = 28.dp, top = 2.dp),
                        style = AppTypography.bodyMedium,
                        color = G200
                    )
                }
                IconButton(onClick = { navController.navigate(Route.PROFILE)}){
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "Profile",
                        modifier = modifier.size(24.dp),
                        tint = G200,

                        )
                }

            }
            HorizontalDivider(
                color = G40,
                thickness = 1.dp,
                modifier = modifier.padding(vertical = 16.dp)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    , horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier=modifier.align(Alignment.CenterVertically)) {
                    Icon(
                        painter = painterResource(id = R.drawable.fill),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp),
                        tint = G200
                    )

                    Text(
                        text = "Help",
                        modifier = modifier
                            .padding(start = 28.dp, top = 2.dp),
                        style = AppTypography.bodyMedium,
                        color = G200
                    )
                }
                IconButton(onClick = { showBottomSheet=true }){
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "Help",
                        modifier = modifier.size(24.dp),
                        tint = G200,

                        )
                }

            }
            HorizontalDivider(
                color = G40,
                thickness = 2.dp,
                modifier = modifier.padding(vertical = 16.dp)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier=modifier.align(Alignment.CenterVertically)) {
                    Icon(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp),
                        tint = G200
                    )

                    Text(
                        text = "logout",
                        modifier = modifier
                            .padding(start = 28.dp, top = 2.dp),
                        style = AppTypography.bodyMedium,
                        color = G200
                    )
                }
                IconButton(onClick = {
                    logout.invoke()
                }){
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp),
                        tint = G200,

                        )
                }

            }
        }
    }

    
}

@Preview
@Composable
private fun MoreScreenPreview() {
    MoreScreen(navController = rememberNavController(), logout = {})

}

