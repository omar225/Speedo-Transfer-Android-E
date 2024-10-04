package com.example.speedotransfer.model

import com.example.speedotransfer.constants.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  AppAPIService {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL) //https://bm-groupe.onrender.com/
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    val callable by lazy {
        retrofit.create(AppAPICallable::class.java)
    }
}