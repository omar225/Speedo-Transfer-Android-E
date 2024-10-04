package com.example.speedotransfer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.model.AppAPIService
import com.example.speedotransfer.model.LoginRequestDTO
import com.example.speedotransfer.model.LoginResponseDTO
import com.example.speedotransfer.model.UserSignUp
import com.example.speedotransfer.model.UserSignUpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel : ViewModel() {

    private val _login = MutableStateFlow<LoginResponseDTO?>(null)
    val login = _login.asStateFlow()

    fun login(loginRequest: LoginRequestDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _login.value = AppAPIService.callable.login(loginRequest)

            } catch (e: Exception) {
                Log.d("trace", "Error in sign in : ${e.message}")

            }
        }
    }
}