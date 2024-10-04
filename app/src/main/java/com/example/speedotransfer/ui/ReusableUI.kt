package com.example.speedotransfer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.signinandup.validatePassword
import com.example.speedotransfer.ui.theme.AppTypography
import com.example.speedotransfer.ui.theme.CountryText
import com.example.speedotransfer.ui.theme.D300
import com.example.speedotransfer.ui.theme.G0
import com.example.speedotransfer.ui.theme.G10
import com.example.speedotransfer.ui.theme.G70
import com.example.speedotransfer.ui.theme.G700
import com.example.speedotransfer.ui.theme.P50
import com.example.speedotransfer.ui.transferscreens.AmontScreen
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TextFields(
    inputText: String,
    secondInputText: String,
    inputTextField: MutableState<String>,
    image: Int? = null,
    type: KeyboardType,
    modifier: Modifier = Modifier
)  {

    Text(
        text = inputText,
        style = AppTypography.bodyLarge,
        modifier = modifier.padding(top = 12.dp)
    )
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        value = inputTextField.value,
        onValueChange = { inputTextField.value = it },
        textStyle = AppTypography.bodySmall,
        shape = RoundedCornerShape(4.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = type),
        placeholder = { Text(text = secondInputText, color = G70) },
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
            if (image != null) {
                IconButton(onClick = {
                }
                ) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = "",
                        modifier = modifier.size(25.dp)
                    )
                }
            }
        }
    )

}

@Composable
fun PasswordTextFields(
    inputText: String,
    secondInputText: String,
    inputTextField: MutableState<String>,
    modifier: Modifier = Modifier
) {


    var isPasswordShown by remember {
        mutableStateOf(true)
    }

    var isValid by remember {
        mutableStateOf(true)
    }
    isValid = validatePassword(inputTextField.value)

    val color by remember {
        derivedStateOf {
            when{
                inputTextField.value.isBlank()-> G700
                isValid-> G700
                else-> D300

            }
        }
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
        value = inputTextField.value,
        onValueChange = { inputTextField.value = it

        },

        isError = !isValid && inputTextField.value.isNotBlank() ,
        textStyle = AppTypography.bodySmall,
        shape = RoundedCornerShape(4.dp),
        singleLine = true,
        placeholder = { Text(text = secondInputText, color = G70) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = G700,
            unfocusedTextColor = G700,
            focusedContainerColor = G10,
            unfocusedContainerColor = G10,
            focusedIndicatorColor = color,
            unfocusedIndicatorColor = if(inputTextField.value.isBlank()) G70 else color,
            focusedTrailingIconColor = color,
            unfocusedTrailingIconColor =if(inputTextField.value.isBlank()) G70 else color,
            errorIndicatorColor = D300,
            errorContainerColor = G10,
            errorTrailingIconColor = D300,
        ),
        supportingText = {
            if (!isValid && inputTextField.value.isNotBlank()) {
                Text(
                    text = "Password must be 6 characters with at least one capital letter, one small letter and a special character",
                    color = Color.Red,
                    style = AppTypography.bodySmall
                )
            }

        },
        visualTransformation = if (isPasswordShown) PasswordVisualTransformation('*') else VisualTransformation.None,
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

@Composable
fun ConfirmPasswordTextFields(
    inputText: String,
    inputTextField: String,
    passedVal: String,
    modifier: Modifier = Modifier
) {
    var passwordField by remember {
        mutableStateOf("")
    }

    var isPasswordShown by remember {
        mutableStateOf(true)
    }

    var isValid by remember {
        mutableStateOf(true)
    }

    if (passedVal == passwordField) {
        isValid = true
    } else {
        isValid = false
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
        isError = !isValid,
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
            errorCursorColor = G700,
            errorContainerColor = G10,
            errorTextColor = G700,
        ),
        visualTransformation = if (isPasswordShown) PasswordVisualTransformation('*') else VisualTransformation.None,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField(
    inputText: String,
    secondInputText: String,
    inputTextField: MutableState<String>,
    modifier: Modifier = Modifier
) {

    var isDatePickerShown by remember { mutableStateOf(false) }
    var dateMillis by remember { mutableLongStateOf(0L) }

    if (isDatePickerShown)
        DatePickerChooser(onConfirm = {
            val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            dateMillis = it.selectedDateMillis!!
            inputTextField.value = dateFormatter.format(dateMillis)
            isDatePickerShown = false
        }) {
            isDatePickerShown = false
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
        value = inputTextField.value,
        onValueChange = { inputTextField.value = it },
        textStyle = AppTypography.bodySmall,
        shape = RoundedCornerShape(4.dp),
        singleLine = true,
        readOnly = true,
        placeholder = { Text(text = secondInputText, color = G70) },
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
            IconButton(onClick = { isDatePickerShown = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.date),
                    contentDescription = "",
                    modifier = modifier.size(25.dp)
                )
            }

        }
    )

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerChooser(
    onConfirm: (DatePickerState) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = { onConfirm(datePickerState) }) {
                Text(text = "OK")
            }

        }, dismissButton = {
            TextButton(
                onClick = { onDismiss() }) {
                Text(text = "Cancel")
            }
        }
    )
    {
        DatePicker(state = datePickerState)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPickerField(
    inputText: String,
    secondInputText: String,
    inputTextField: MutableState<String>,
    modifier: Modifier = Modifier
) {
    var isModalSheetShown by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()


    if (isModalSheetShown) {
        ModalBottomSheet(
            onDismissRequest = { isModalSheetShown = false },
            sheetState = sheetState,
            containerColor = G0,


            ) {
            CountryList(
                onCountrySelected = { country -> inputTextField.value = country },
                selectedCountry = inputTextField.value
            )

        }
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
        value = inputTextField.value,
        onValueChange = {},
        textStyle = AppTypography.bodySmall,
        shape = RoundedCornerShape(4.dp),
        singleLine = true,
        readOnly = true,
        placeholder = { Text(text = secondInputText, color = G70) },
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
            IconButton(onClick = { isModalSheetShown = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_down),
                    contentDescription = "",
                    modifier = modifier.size(25.dp)
                )
            }

        }
    )


}

@Composable
fun CountryList(
    onCountrySelected: (String) -> Unit,
    selectedCountry: String
) {
    val countries = listOf(
        Pair("Egypt", painterResource(id = R.drawable.egypt)),
        Pair("United States", painterResource(id = R.drawable.united_states)),
        Pair("Saudi Arabia", painterResource(id = R.drawable.saudi_arabia)),
        Pair("United Arab Emirates", painterResource(id = R.drawable.united_arab_emirates)),
        Pair("Canada", painterResource(id = R.drawable.canada)),
        Pair("Germany", painterResource(id = R.drawable.germany)),
        Pair("France", painterResource(id = R.drawable.france)),
        Pair("United Kingdom", painterResource(id = R.drawable.united_kingdom)),
    )


    LazyColumn {
        items(countries) { (country, flag) ->
            val isSelected = country == selectedCountry
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (isSelected) P50 else Color.Transparent)
                    .height(56.dp)
                    .clickable { onCountrySelected(country) }
                    .padding(horizontal = 20.dp)
            ) {
                Image(
                    painter = flag,
                    contentDescription = "flag",
                    Modifier
                        .size(28.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = country,
                    style = AppTypography.bodyMedium,
                    color = CountryText
                )
                Spacer(modifier = Modifier.weight(1f))

                if (isSelected) {
                    Image(
                        painter = painterResource(id = R.drawable.check),
                        contentDescription = "check",
                        Modifier
                            .size(16.dp)

                    )
                }


            }
        }
    }
}


