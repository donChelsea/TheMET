package com.example.themet.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {

    val metService = Retrofit.Builder()
            .baseUrl("https://collectionapi.metmuseum.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MetService::class.java)
}
