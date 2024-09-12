package com.example.speedotransfer.model

import com.example.speedotransfer.constants.Constants.LOGIN_ENDPOINT
import com.example.speedotransfer.constants.Constants.REGISTRATION_ENDPOINT
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AppAPICallable {
    @POST(LOGIN_ENDPOINT)
    suspend fun login(
        @Body loginRequest: UserLogin
    ): Response<UserLoginResponse>

    @POST(REGISTRATION_ENDPOINT)
    suspend fun signup(
        @Body signupRequest: UserSignUp
    ): Response<UserSignUpResponse>

}