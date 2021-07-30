package com.example.themet.network

import android.util.Log
import com.example.themet.models.Department
import com.example.themet.models.Departments
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetRepository {

    private val TAG = "MetRepository"

    var departments = mutableListOf<Department>()

    fun getDepartmentsRepo(): List<Department> {


        Log.d(TAG, "onResponse: " + departments[0].departmentId)
        return departments
    }


}