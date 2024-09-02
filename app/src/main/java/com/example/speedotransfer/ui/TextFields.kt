package com.example.speedotransfer.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.D300
import com.example.speedotransfer.ui.theme.G10
import com.example.speedotransfer.ui.theme.G70
import com.example.speedotransfer.ui.theme.G700

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
        textStyle = AppTypography.bodySmall,
        shape = RoundedCornerShape(4.dp),
        singleLine = true,
        placeholder = { Text(text = inputTextField, color = G70) } ,
        colors = TextFieldDefaults.colors(
            focusedTextColor = G700,
            unfocusedTextColor = G700,
            focusedContainerColor = G10,
            unfocusedContainerColor = G10,
            focusedIndicatorColor = G700,
            unfocusedIndicatorColor = G70,
            focusedTrailingIconColor = G700,
            unfocusedTrailingIconColor = G70,
            errorIndicatorColor = D300,
            errorTrailingIconColor = D300,
            cursorColor = G700
        ),
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
        textStyle = AppTypography.bodySmall,
        shape = RoundedCornerShape(4.dp),
        singleLine = true,
        placeholder = { Text(text = inputTextField, color = G70) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = G700,
            unfocusedTextColor = G700,
            focusedContainerColor = G10,
            unfocusedContainerColor = G10,
            focusedIndicatorColor = G700,
            unfocusedIndicatorColor = G70,
            focusedTrailingIconColor = G700,
            unfocusedTrailingIconColor = G70,
            cursorColor = G700,
            errorIndicatorColor = D300,
            errorTrailingIconColor = D300,
        ),
        visualTransformation = if (isPasswordShown)  PasswordVisualTransformation('*') else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (isPasswordShown) R.drawable.eye_comp_1 else R.drawable.eye_comp
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