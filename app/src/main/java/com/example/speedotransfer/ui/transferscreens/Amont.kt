package com.example.speedotransfer.ui.transferscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.model.FavouriteResponse
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.TextFields
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G30
import com.example.speedotransfer.ui.theme.G300
import com.example.speedotransfer.ui.theme.G40
import com.example.speedotransfer.ui.theme.G700
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P50
import com.example.speedotransfer.ui.theme.P75
import com.example.speedotransfer.viewmodel.FavouritesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmontScreen(navController: NavHostController,customerAccountNumber: String, favouritesViewModel: FavouritesViewModel=viewModel(), modifier: Modifier = Modifier) {
    favouritesViewModel.getFavourite(customerAccountNumber)
    val favourites by favouritesViewModel.favourites.collectAsState()

    var amountSent = rememberSaveable {
        mutableStateOf("")
    }

    var recipientName = rememberSaveable {
        mutableStateOf("")
    }
    var recipientAccount = rememberSaveable {
        mutableStateOf("")
    }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet = remember { mutableStateOf(false) }

    if (showBottomSheet.value) {
        ModalBottomSheet(
            modifier = modifier.fillMaxSize(),
            onDismissRequest = {
                showBottomSheet.value = false
            },
            sheetState = sheetState
        ) {
            // Sheet content
            FavouritesBottomSheet(favourites,recipientName, recipientAccount, showBottomSheet)
        }
    }

    Column(

        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = ScrollState(5), enabled = true)
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Home, Login
                    )
                )
            )
    ) {
        Spacer(modifier = modifier.height(40.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            IconButton(
                modifier = modifier
                    .size(24.dp),
                onClick = { navController.navigate(Route.HOME) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "back button",
                    modifier = modifier.size(24.dp)
                )

            }
            Text(
                text = "Transfer",
                style = AppTypography.titleMedium,
                modifier = modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }
        Spacer(modifier = modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.stepper_horizontal_1),
            contentDescription = "",
            modifier = modifier
                .padding(horizontal = 16.dp)
                .size(width = 370.dp, height = 40.dp)
        )
        Spacer(modifier = modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Amount",
                style = AppTypography.bodyMedium
            )
            Text(
                text = "Confirmation",
                style = AppTypography.bodyMedium
            )
            Text(
                text = "Payment",
                style = AppTypography.bodyMedium
            )

        }
        Text(
            text = "How much are you sending?",
            modifier = modifier.padding(top = 32.dp, start = 16.dp),
            style = AppTypography.titleSemiBold
        )
        Spacer(modifier = modifier.height(28.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(Color.White)
        )
        {
            TextFields(
                inputText = "Amount",
                "Enter your amount",
                inputTextField = amountSent,
                null,
                KeyboardType.Number,
                modifier = modifier
                    .padding(horizontal = 16.dp)


            )
            Spacer(modifier = modifier.height(28.dp))
        }
        Spacer(modifier = modifier.height(14.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Recipient Information",
                style = AppTypography.bodyLarge
            )

            TextButton(
                onClick = { showBottomSheet.value = true },
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = "",
                    modifier = modifier
                        .size(20.dp),
                    tint = P300
                )
                Text(
                    text = "Favourite",
                    modifier = modifier.padding(start = 8.dp),
                    style = AppTypography.bodyLarge,
                    color = P300
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = "",
                    modifier = modifier
                        .padding(start = 4.dp)
                        .size(14.dp)
                        .align(Alignment.CenterVertically),
                    tint = P300
                )
            }

        }
        TextFields(
            inputText = "Recipient Name","Enter Recipient Name",
            inputTextField = recipientName,
            null,
            KeyboardType.Unspecified,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        TextFields(
            inputText = "Recipient Account","Enter Recipient Account Number",
            inputTextField = recipientAccount,
            null,
            KeyboardType.Number,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = modifier.height(35.dp))

        Button(
            enabled = amountSent.value.isNotBlank() && recipientName.value.isNotBlank() && recipientAccount.value.isNotBlank(),
            onClick = { navController.navigate("${Route.CONFIRMATION}/${amountSent.value}/${recipientName.value}/${recipientAccount.value}/${customerAccountNumber}") }, modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(51.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(P300)
        ) {
            Text(text = "Continue ", style = AppTypography.button)
        }

        Spacer(modifier = modifier.height(58.dp))
    }
}

@Composable
fun FavouritesBottomSheet(favourites: List<FavouriteResponse>, recipientName: MutableState<String>, recipientAccount: MutableState<String>, showBottomSheet: MutableState<Boolean>, modifier: Modifier = Modifier) {
    LazyColumn {

        items(favourites.size) {item->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = "",
                    modifier = modifier
                        .size(20.dp),
                    tint = P300
                )
                Text(
                    text = "Favourite List",
                    modifier = modifier.padding(start = 8.dp),
                    style = AppTypography.bodyLarge,
                    color = P300
                )
            }

            Card(
                colors = CardDefaults.cardColors(P50),
                border = BorderStroke(color = P75, width = 2.dp),
                modifier = modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        showBottomSheet.value = false
                        recipientName.value = favourites[item].favourite_name!!
                        recipientAccount.value = favourites[item].favourite_accountNumber!!

                    }
            ) {

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
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
                                text = favourites[item].favourite_accountNumber!!,
                                style = AppTypography.bodyLarge,
                                color = G100,
                                textAlign = TextAlign.Center
                            )


                        }
                    }
                }


            }
        }
    }

}


@Preview
@Composable
private fun AmountScreenPreview() {
    AmontScreen(navController = rememberNavController(),customerAccountNumber = "123456789")
}
