package com.example.speedotransfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G100
import com.example.speedotransfer.ui.theme.G400
import com.example.speedotransfer.ui.theme.Login
import com.example.speedotransfer.ui.theme.P300
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

@Composable
fun SignUp(modifier: Modifier = Modifier) {

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
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {


            Text(
                text = "Sign Up",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
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
            TextFields("Full Name", "Enter your Full Name", R.drawable.user)
            TextFields("Email", "Enter your email address", R.drawable.email)
            PasswordTextFields("Password", "Enter your password")
            PasswordTextFields("Confirm Password", "Enter your password")
            Button(
                onClick = { }, modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Sign up ", style = AppTypography.button)
            }
            Text(

                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = G100, fontSize = 18.sp)
                    )
                    {
                        append("Already have an account?  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = P300,
                            textDecoration = TextDecoration.Underline,
                            fontSize = 18.sp
                        )
                    )
                    {
                        append("Sign in")
                    }
                },
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),

                )

        }
    }


}



@Composable
fun TextFields(
    inputText: String,
    inputTextField: String,
    image: Int,
    modifier: Modifier = Modifier
) {
    var input by remember {
        mutableStateOf("")
    }
    Text(
        text = inputText,
        style = AppTypography.bodyLarge,
        modifier = modifier.padding(top = 12.dp)
    )
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        value = input,
        onValueChange = { input = it },
        textStyle = TextStyle(color = G100),
        shape = RoundedCornerShape(4.dp),
        label = { Text(text = inputTextField) },
        colors = TextFieldDefaults.colors(focusedContainerColor = G0, unfocusedContainerColor = G0),
        trailingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = modifier.size(25.dp)
                )
            }

        }
    )
}

@Composable
fun PasswordTextFields(inputText: String, inputTextField: String, modifier: Modifier = Modifier) {
    var passwordField by remember {
        mutableStateOf("")
    }

    var isPasswordShown by remember {
        mutableStateOf(true)
    }
    Text(
        text = inputText,
        style = AppTypography.bodyLarge,
        modifier = modifier.padding(top = 12.dp)
    )
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        value = passwordField,
        onValueChange = { passwordField = it },
        textStyle = TextStyle(color = G100),
        shape = RoundedCornerShape(4.dp),
        label = { Text(text = inputTextField) },
        visualTransformation = if (isPasswordShown) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (isPasswordShown) R.drawable.eye_comp else R.drawable.eye_comp_1
            IconButton(onClick = {
                isPasswordShown = !isPasswordShown
            }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = modifier.size(25.dp)
                )
            }

        }
    )
}

@Composable
fun SecondSignUp(modifier: Modifier = Modifier) {
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
        IconButton(onClick = { /*TODO*/ }, modifier = modifier.align(Alignment.TopStart)) {
            Icon(
                painter = painterResource(id = R.drawable.drop_down),
                contentDescription = "back button",
                modifier = modifier.size(24.dp)
            )

        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp,top = 32.dp)
        ) {



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
            TextFields("Country", "Select your country", R.drawable.chevron_down)
            TextFields("Date of Birth", "DD/MM/YYY", R.drawable.date)
            Button(
                onClick = { }, modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(P300)
            ) {
                Text(text = "Continue ", style = AppTypography.button)
            }
            Text(

                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = G100, fontSize = 18.sp)
                    )
                    {
                        append("Already have an account?  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = P300,
                            textDecoration = TextDecoration.Underline,
                            fontSize = 18.sp
                        )
                    )
                    {
                        append("Sign in")
                    }
                },
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),

                )

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    SecondSignUp()
}