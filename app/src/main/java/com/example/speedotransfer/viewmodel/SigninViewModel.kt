package com.example.speedotransfer.viewmodel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.model.AppAPIService
import com.example.speedotransfer.model.CustomerDTO
import com.example.speedotransfer.model.LoginRequestDTO
import com.example.speedotransfer.model.LoginResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(sharedPre: SharedPreferences) : ViewModel() {

    private val _login = MutableStateFlow<LoginResponseDTO?>(null)
    val login = _login.asStateFlow()

    private val _customerResponse = MutableStateFlow<CustomerDTO?>(null)
    val customerResponse = _customerResponse.asStateFlow()

    fun login(loginRequest: LoginRequestDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _login.value = AppAPIService.callable.login(loginRequest)

            } catch (e: Exception) {
                Log.d("trace", "Error in sign in : ${e.message}")

            }
        }
    }

    fun getCustomer(email :String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _customerResponse.value = AppAPIService.callable.getCustomer(email)

            } catch (e: Exception) {
                Log.d("trace", "Error in fetching customer info : ${e.message}")

            }
        }

    }


    private val editor =sharedPre.edit()
    fun saveCustomerData(customerDTO: CustomerDTO) {
        editor.apply {
            putString("name", customerDTO.name)
            putString("email", customerDTO.email)

            val account=customerDTO.accounts[0]
            putString("accountNumber", account.accountNumber)
            putString("accountName", account.accountName)
            putInt("balance", account.balance)
            apply()

        }
    }
}