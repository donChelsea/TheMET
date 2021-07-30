package com.example.themet.network

import com.example.themet.models.Departments
import retrofit2.Call
import retrofit2.http.GET

interface MetService {

    @GET("public/collection/v1/departments")
    fun getDepartments(): Call<Departments>

}