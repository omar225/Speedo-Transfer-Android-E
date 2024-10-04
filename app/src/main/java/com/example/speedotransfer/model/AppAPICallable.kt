package com.example.speedotransfer.model

import com.example.speedotransfer.constants.Constants.BALANCE_ENDPOINT
import com.example.speedotransfer.constants.Constants.FAVORITES_ENDPOINT
import com.example.speedotransfer.constants.Constants.LOGIN_ENDPOINT
import com.example.speedotransfer.constants.Constants.REGISTRATION_ENDPOINT
import com.example.speedotransfer.constants.Constants.TRANSACTIONS_ENDPOINT
import com.example.speedotransfer.ui.navigation.NavigationItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AppAPICallable {
    @POST(LOGIN_ENDPOINT)
    suspend fun login(
        @Body loginRequest: LoginRequestDTO
    ): LoginResponseDTO

    @POST(REGISTRATION_ENDPOINT)
    suspend fun signup(
        @Body signupRequest: UserSignUp
    ): UserSignUpResponse

    @POST(TRANSACTIONS_ENDPOINT)
    suspend fun transfer(
        @Body transferRequest: Transfer
    ):TransferResponse

    @POST(FAVORITES_ENDPOINT)
    suspend fun addToFavorites(
        @Body addFavouritesRequest: AddFavourites
    ): AddFavouriteResponse

    @GET(TRANSACTIONS_ENDPOINT)
    suspend fun getTransactionsHistory(
        accountNumber: String
    ):List<TransactionResponse>

    @GET(FAVORITES_ENDPOINT)
    suspend fun getFavorites(
        accountNumber: String
    ): List<FavouriteResponse>


    @DELETE(FAVORITES_ENDPOINT)
    suspend fun deleteFavorites(@Path("id") id: Long): DeleteFavouriteResponse


}