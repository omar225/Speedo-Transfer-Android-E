package com.example.speedotransfer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.model.AppAPIService
import com.example.speedotransfer.model.Transfer
import com.example.speedotransfer.model.TransferResponse
import com.example.speedotransfer.model.LoginRequestDTO
import com.example.speedotransfer.model.LoginResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TransferViewModel: ViewModel() {

    private val _transferResponse = MutableStateFlow<TransferResponse?>(null)
    val transferResponse = _transferResponse.asStateFlow()

    fun transfer(transferRequest: Transfer) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _transferResponse.value = AppAPIService.callable.transfer(transferRequest)

            } catch (e: Exception) {
                Log.d("trace", "Error in sign in : ${e.message}")

            }
        }
    }
}