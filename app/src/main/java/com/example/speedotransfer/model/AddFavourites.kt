package com.example.speedotransfer.model

data class AddFavourites(

    val customerAccountNumber: String="",
    val favouriteAccountNumber: String="",

    )

data class AddFavouriteResponse(
    val status: String="",
)
