package com.example.speedotransfer.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.model.AppAPIService
import com.example.speedotransfer.model.TransactionResponse
import com.example.speedotransfer.model.UserSignUp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TransactionsViewModel:ViewModel() {

    private val _transactions = MutableStateFlow<List<TransactionResponse>>(emptyList())
    val transactions= _transactions

    fun getTransactions(accountNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _transactions.value= AppAPIService.callable.getTransactionsHistory(accountNumber)

            } catch (e: Exception) {
                Log.d("trace", " Error in getting transactions history: ${e.message}")

            }
        }
    }
}