package com.example.speedotransfer.ui.signinandup

fun validatePassword(password: String): Boolean {
    val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@\$#%^&+=!]).{6,}$")
    return passwordRegex.matches(password)
}