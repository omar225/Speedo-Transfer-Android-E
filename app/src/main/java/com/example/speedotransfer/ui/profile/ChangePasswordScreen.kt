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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.speedotransfer.ui.ConfirmPasswordTextFields
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.CountryPickerField
import com.example.speedotransfer.ui.DatePickerField
import com.example.speedotransfer.ui.PasswordTextFields
import com.example.speedotransfer.ui.TextFields
import com.example.speedotransfer.ui.signinandup.validatePassword
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G900
import com.example.speedotransfer.ui.theme.Home
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300

@Composable
fun ChangePasswordScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val name = "Asmaa Dosuky"
    var oldPassword = remember {
        mutableStateOf("")
    }
    var newPassword = remember {
        mutableStateOf("")
    }
    var isValid by remember {
        mutableStateOf( false)
    }
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
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.padding(top = 40.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp, 0.dp, 16.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down),
                        contentDescription = "back icon",
                        tint = G900,
                        modifier = modifier
                            .size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Change Password",
                    style = AppTypography.titleMedium,
                    color = G900,
                )

                Spacer(modifier = Modifier.weight(1f))

            }

            PasswordTextFields( "Current Password","Enter your old password", inputTextField =oldPassword )
            PasswordTextFields("New Password","Enter  new password", inputTextField =newPassword )
            isValid= validatePassword(newPassword.value)
            Button(
                enabled=isValid,
                onClick = {navController.navigate(Route.SETTINGS) }, modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Save", style = AppTypography.button)
            }

        }
    }
}

@Preview
@Composable
private fun ChangePasswordScreenPreview() {
    ChangePasswordScreen(navController = rememberNavController())
}