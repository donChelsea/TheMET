package com.example.themet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.themet.models.Department
import com.example.themet.models.Departments
import com.example.themet.network.RetrofitSingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val metService = RetrofitSingleton.metService.getDepartments()

        metService.enqueue(object : Callback<Departments> {
            override fun onResponse(call: Call<Departments>, response: Response<Departments>) {
                Log.d(TAG, "onResponse: " + (response.body()?.departments?.get(0)?.displayName))
            }

            override fun onFailure(call: Call<Departments>, t: Throwable) {
                Log.d(TAG, "onFailure: something went wrong " + t.message)
            }
        })
    }


}