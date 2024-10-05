package com.example.speedotransfer.model

data class AccountDTO (
    val id:Int=-1,
    val name: String="",
    val accountNumber: String="",
    val accountType: String="",
    val balance: Int=0,
    val currency: String="",
    val accountName: String="",
    val accountDescription: String="",
    val active: Boolean=true,
    val createdAt: String="",
    val updatedAt: String=""

)

