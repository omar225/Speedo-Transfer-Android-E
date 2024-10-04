package com.example.speedotransfer.model

data class LoginRequestDTO (
    val email: String="",
    val password: String="",
    val accountNumber: String=""
)
data class LoginResponseDTO(
    val token: String,
    val tokenType:String,
    val message: String,
    val status: String // Consider using an enum for status codes
)

