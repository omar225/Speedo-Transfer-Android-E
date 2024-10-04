package com.example.speedotransfer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.model.AppAPIService
import com.example.speedotransfer.model.UserSignUp
import com.example.speedotransfer.model.UserSignUpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel : ViewModel() {

    private val _signup = MutableStateFlow<UserSignUpResponse?>(null)
    val signup = _signup.asStateFlow()



    fun signup(signupRequest: UserSignUp) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _signup.value= AppAPIService.callable.signup(signupRequest)

            } catch (e: Exception) {
                Log.d("trace", "Signup Error: ${e.message}")

            }
        }
    }
}