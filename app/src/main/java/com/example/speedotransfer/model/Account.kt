package com.example.speedotransfer.model

data class AccountDTO (
    val id:Int,
    val name: String="",
    val accountNumber: String="",
    val accountType: String="",
    val balance: Int,
    val currency: String="",
    val accountName: String="",
    val accountDescription: String="",
    val active: Boolean,
    val createdAt: String="",
    val updatedAt: String=""

)

