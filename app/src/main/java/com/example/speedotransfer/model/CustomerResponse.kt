package com.example.speedotransfer.model

data class CustomerDTO (
    val id: Int,
    val name: String="",
    val email: String="",
    val createdAt: String="",
    val updatedAt: String="",
    val accounts: List<AccountDTO>
)

