package com.example.speedotransfer.constants

object Constants {
    const val BASE_URL = "https://bm-groupe.onrender.com" //use http://10.0.2.2:8080" to test on local server
    const val REGISTRATION_ENDPOINT = "/api/register"
    const val LOGIN_ENDPOINT = "/api/login"
    const val LOGOUT_ENDPOINT = "/api/logout"
    const val BALANCE_ENDPOINT = "/api/balance"
    const val DELETE_FAVORITES_ENDPOINT="/api/favorites/{id}"
    const val FAVORITES_ENDPOINT = "/api/favorites"
    const val TRANSACTIONS_ENDPOINT = "/api/transactions"
    const val GET_CUSTOMER_BY_EMAIL_ENDPOINT = "/api/customer/{customerEmail}"
}