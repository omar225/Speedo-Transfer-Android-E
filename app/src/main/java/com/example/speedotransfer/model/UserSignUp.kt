package com.example.speedotransfer.model

class UserSignUp (

    val name: String="",
    val email: String="",
    val  password: String="",
    val  dateOfBirth: String="",
    val  country: String=""
    )


data class UserSignUpResponse(
     val id:Int,
   val name: String,
   val email:String,
    val accountNumber: String
)