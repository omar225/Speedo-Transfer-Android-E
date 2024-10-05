package com.example.speedotransfer.model

data class CustomerDTO (
    val id: Int=-1,
    val name: String="",
    val email: String="",
    val createdAt: String="",
    val updatedAt: String="",
    val accounts: List<AccountDTO>
)

