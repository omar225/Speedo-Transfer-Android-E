package com.example.speedotransfer.ui.mainscreens

import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.TextFields
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.D300
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G200
import com.example.speedotransfer.ui.theme.G30
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.G700
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.viewmodel.FavouritesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavHostController, favouritesViewModel: FavouritesViewModel = viewModel(), modifier: Modifier = Modifier) {
    val favourites by favouritesViewModel.favourites.collectAsState()
    val deleteFavouriteResponse by favouritesViewModel.deleteFavouriteResponse.collectAsState()
    val context = LocalContext.current

    deleteFavouriteResponse?.let{
        if(it.status=="success")
            Toast.makeText(context, "Deleting Favourite is Successful", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Deleting Favourite is Failed", Toast.LENGTH_SHORT).show()
    }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var favouriteName = rememberSaveable {
        mutableStateOf("Enter Cardholder Name")
    }
    var favouriteAccountNumber = rememberSaveable {
        mutableStateOf("Enter Cardholder Account Number")
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

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            {
                TextFields(inputText = "Favourite Name", "",inputTextField = favouriteName,null,KeyboardType.Unspecified)
                TextFields(
                    inputText = "Favourite Account","",
                    inputTextField = favouriteAccountNumber,null,KeyboardType.Number
                )


            }
            Button(
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                        favouriteName.value="Enter Cardholder Name"
                        favouriteAccountNumber.value="Enter Cardholder Account Number"
                    }
                }, modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .height(51.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Save ", style = AppTypography.button)
            }

            Spacer(modifier = modifier.height(60.dp))

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
            Spacer(modifier = modifier.height(40.dp))
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
            LazyColumn{
                items(favourites.size) { item ->
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

                                    Text(text = favourites[item].favourite_name!!, style = AppTypography.bodyMedium)
                                    Text(
                                        text = "Account xxxx${favourites[item].favourite_accountNumber!!.takeLast(4)}",
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
                                IconButton(onClick = {
                                    favouritesViewModel.deleteFavourite(favourites[item].favourite_Id!!)
                                }, modifier = modifier.padding(start = 40.dp)) {
                                    Icon(painter = painterResource(id = R.drawable.delete), modifier =modifier.size(24.dp), contentDescription ="edit", tint = D300 )

                                }

                            }
                        }


                    }

                }

            }





        }
    }

}


@Preview
@Composable
private fun FavouriteScreenPreview() {
    FavouriteScreen(rememberNavController())

    
}