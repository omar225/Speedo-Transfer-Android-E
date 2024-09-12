package com.example.speedotransfer.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AppAPICallable {
    @POST("login")
    suspend fun login(
        @Body loginRequest: UserLogin
    ): Response<UserLogin>
    @POST("signup")
    suspend fun signup(
        @Body signupRequest: UserSignUp
    ): Response<UserSignUp>



}