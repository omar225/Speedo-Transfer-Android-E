package com.example.speedotransfer.model

import java.time.LocalDateTime



data class TransactionResponse (
     val sourceAccountNumber: String,
     val sourceName: String,
     val destinationAccountNumber: String,
     val destinationName: String,
     val amount :Int ,
     val transactionDate: String,
     val status: String
)


