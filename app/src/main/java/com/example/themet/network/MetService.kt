package com.example.themet.network

import com.example.themet.models.Departments
import com.example.themet.models.MetObject
import com.example.themet.models.ObjectIds
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MetService {

    @GET("public/collection/v1/departments")
    fun getDepartments(): Call<Departments>

    @GET("public/collection/v1/objects")
    fun getAllObjectsInDepartment(@Query("departmentIds") departmentId: Int): Call<ObjectIds>

    @GET("public/collection/v1/objects/{objectID}")
    fun getSingleObject(@Path("objectID") objectId: Int): Call<MetObject>

}