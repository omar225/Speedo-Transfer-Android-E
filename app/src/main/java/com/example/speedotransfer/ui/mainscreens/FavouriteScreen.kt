package com.example.speedotransfer.ui.mainscreens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.speedotransfer.R
import com.example.speedotransfer.navigation.Route
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.D300
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G30
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.G700
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var recipientName by rememberSaveable {
        mutableStateOf("")
    }
    var recipientAccount by rememberSaveable {
        mutableStateOf("")
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            // Sheet content
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edit),
                    colorFilter = ColorFilter.tint(P300),
                    contentDescription = "edit",
                    modifier = modifier.size(24.dp)
                )
                Text(
                    text = "Edit",
                    modifier = modifier.padding(start = 12.dp),
                    style = AppTypography.bodyLarge,
                    color = G700
                )
            }
            Text(
                text = "Recipient Account",
                modifier = modifier.padding(start = 12.dp),
                style = AppTypography.bodyLarge,
                color = G100
            )
            OutlinedTextField(
                value = recipientAccount,
                onValueChange = { recipientAccount = it },
                label = { Text(text = "Enter Recipient Account Number") },
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
                text = "Recipient Name",
                modifier = modifier.padding(top = 12.dp, start = 12.dp),
                style = AppTypography.bodyLarge,
                color = G100
            )
            OutlinedTextField(
                value = recipientName,
                onValueChange = { recipientName = it },
                label = { Text(text = "Enter Recipient Name") },
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
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                        recipientName=""
                        recipientAccount=""
                    }
                }, modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Save ", style = AppTypography.button)
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
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                IconButton(onClick = { navController.navigate(Route.MORE) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down),
                        contentDescription = "back button",
                        modifier = modifier.size(24.dp)
                    )

                }
                Text(
                    text = "Favourite",
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(end = 20.dp),
                    style = AppTypography.titleMedium,
                    textAlign = TextAlign.Center
                )

            }

            Text(
                text = "Your Favourite list",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 16.dp),
                style = AppTypography.titleSemiBold,
                textAlign = TextAlign.Center
            )
            Card(
                colors = CardDefaults.cardColors(
                    G30
                ),modifier = modifier
                    .padding(vertical = 16.dp)
            ) {

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {

                    Row(verticalAlignment = Alignment.CenterVertically){
                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.bank),
                            contentDescription = "",
                            modifier = modifier
                                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)

                                .size(48.dp)
                                .clip(shape = CircleShape)
                                .background(color = G40)
                        )

                        Column() {

                            Text(text = "Asmaa Dosuky", style = AppTypography.bodyMedium)
                            Text(
                                text = "Account xxxx7890",
                                style = AppTypography.bodyLarge,
                                color = G100,
                                textAlign = TextAlign.Center
                            )


                        }
                    }
                    Box(){
                        IconButton(onClick = { showBottomSheet=true }) {
                            Icon(painter = painterResource(id = R.drawable.edit), modifier =modifier.size(24.dp), contentDescription ="edit", tint = G200 )
                            
                        }
                        IconButton(onClick = { /*TODO*/ }, modifier = modifier.padding(start = 40.dp)) {
                            Icon(painter = painterResource(id = R.drawable.delete), modifier =modifier.size(24.dp), contentDescription ="edit", tint = D300 )

                        }

                    }
                }


            }
            Card(
                colors = CardDefaults.cardColors(
                    G30
                )
            ) {

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {

                    Row(verticalAlignment = Alignment.CenterVertically){
                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.bank),
                            contentDescription = "",
                            modifier = modifier
                                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)

                                .size(48.dp)
                                .clip(shape = CircleShape)
                                .background(color = G40)
                        )

                        Column() {

                            Text(text = "Asmaa Dosuky", style = AppTypography.bodyMedium)
                            Text(
                                text = "Account xxxx7890",
                                style = AppTypography.bodyLarge,
                                color = G100,
                                textAlign = TextAlign.Center
                            )


                        }
                    }
                    Box(){
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.edit), modifier =modifier.size(24.dp), contentDescription ="edit", tint = G200 )

                        }
                        IconButton(onClick = { /*TODO*/ }, modifier = modifier.padding(start = 40.dp)) {
                            Icon(painter = painterResource(id = R.drawable.delete), modifier =modifier.size(24.dp), contentDescription ="edit", tint = D300 )

                        }

                    }
                }


            }
        }
    }

}


