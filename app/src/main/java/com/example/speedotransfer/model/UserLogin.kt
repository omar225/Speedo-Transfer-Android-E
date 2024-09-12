package com.example.speedotransfer.model

class UserLogin (
    val email: String="",
    val password: String="",
    val accountNumber: String=""
)
data class UserLoginResponse(
    val token: String,
    val tokenType:String,
    val message: String,
    val status: String // Consider using an enum for status codes
)

