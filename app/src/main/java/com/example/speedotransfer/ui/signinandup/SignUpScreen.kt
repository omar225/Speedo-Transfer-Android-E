package com.example.speedotransfer.ui.signinandup

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.MainActivity
import com.example.speedotransfer.ui.PasswordTextFields
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.navigation.Route
import com.example.speedotransfer.ui.ConfirmPasswordTextFields
import com.example.speedotransfer.ui.CountryPickerField
import com.example.speedotransfer.ui.DatePickerField
import com.example.speedotransfer.ui.TextFields
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G400
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
import com.example.speedotransfer.ui.theme.P500
import com.example.speedotransfer.viewmodel.SignUpViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.speedotransfer.model.UserSignUp

@Composable
fun SignUp(navController: NavController, modifier: Modifier = Modifier) {


    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSignupPressed by remember { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        G0,
                        Login
                    )
                )
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {


            Text(
                text = "Sign Up",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                style = AppTypography.titleSemiBold
            )
            Text(
                text = "Speedo Transfer",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 60.dp),
                style = AppTypography.h2
            )
            name = TextFields("Full Name", "Enter your Full Name", R.drawable.user)
            email = TextFields("Email", "Enter your email address", R.drawable.email)
            password = PasswordTextFields("Password", "Enter your password")
            ConfirmPasswordTextFields("Confirm Password", "Enter your password", password)
            Button(
                onClick = {
                    navController.navigate(route = "${Route.COMPLETEPROFILE}/${name}/${email}/${password}")

                          },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)

                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Sign up ", style = AppTypography.button)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Already have an account?",
                    style = AppTypography.bodyMedium,
                    color = G100
                )
                Text(
                    text = "Sign In",
                    style = AppTypography.linkMedium,
                    color = P300,
                    modifier = modifier
                        .padding(start = 4.dp)
                        .clickable { navController.navigate(route = Route.SIGNIN) }

                )
            }

        }
    }


}

@Composable
fun SecondSignUp(
    navController: NavController,
    firstTime: Boolean,
    context: Context,
    name: String = "",
    email: String = "",
    password: String = "",
    viewModel: SignUpViewModel=viewModel(),
    modifier: Modifier = Modifier
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        G0,
                        Login
                    )
                )
            ), contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            IconButton(
                onClick = { navController.navigate(route = Route.SIGNUP) },
                modifier = modifier
                    .padding(top = 50.dp)
                    .size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "back button",
                    modifier = modifier
                        .size(24.dp)
                )

            }

            Text(
                text = "Speedo Transfer",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 60.dp),
                style = AppTypography.h2
            )
            Text(
                text = "Welcom to Banque Misr!",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                style = AppTypography.h2
            )
            Text(
                text = "Let's complete your profile",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                style = AppTypography.bodyLarge,
                color = G400
            )
            CountryPickerField("Country", "Select your country")
            DatePickerField("Date of Birth", "DD/MM/YYY")
            Button(
                onClick = {
                    val writer =
                        context.getSharedPreferences("FirstTime", Context.MODE_PRIVATE).edit()
                    writer.putBoolean("firstTime", false).apply()
                    viewModel.signup(UserSignUp(name, email, password))
                    navController.navigate(route = Route.SIGNIN)
                }, modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Continue ", style = AppTypography.button)
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Already have an account?",
                    style = AppTypography.bodyMedium,
                    color = G100
                )
                Text(
                    text = "Sign In",
                    style = AppTypography.linkMedium,
                    color = P300,
                    modifier = modifier
                        .padding(start = 4.dp)
                        .clickable {

                            navController.navigate(route = Route.SIGNIN)
                        }

                )
            }

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    SecondSignUp(
        navController = rememberNavController(),
        firstTime = true,
        context = LocalContext.current
    )

}