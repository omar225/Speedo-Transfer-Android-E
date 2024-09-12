package com.example.speedotransfer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.model.AppAPIService
import com.example.speedotransfer.model.UserSignUp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {

    private val _signup = MutableStateFlow(UserSignUp())
    val signup = _signup.asStateFlow()

    private val _hasError = MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()


    fun signup(signupRequest: UserSignUp) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _signup.update {
                    AppAPIService.callable.signup(signupRequest)
                }
                _hasError.update { false }
            } catch (e: Exception) {
                Log.d("trace", "Recipe Error: ${e.message}")
                _hasError.update { true }
            }
        }
    }
}