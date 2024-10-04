package com.example.speedotransfer.model

data class Transfer(

    val sourceAccountNumber: String="",
    val destinationAccountNumber: String="",
    val amount: String="",

    )
data class TransferResponse(

    val status: String=""

    )