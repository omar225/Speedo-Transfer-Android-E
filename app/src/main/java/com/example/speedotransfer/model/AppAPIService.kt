package com.example.speedotransfer.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppAPIService {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    val callable by lazy {
        retrofit.create(AppAPICallable::class.java)
    }
}