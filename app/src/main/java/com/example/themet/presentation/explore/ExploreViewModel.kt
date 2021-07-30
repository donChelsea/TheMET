package com.example.themet.presentation.explore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themet.models.Department
import com.example.themet.models.Departments
import com.example.themet.network.RetrofitSingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreViewModel : ViewModel() {
    private val metService = RetrofitSingleton.metService.getDepartments()

    private val TAG = "MetRepository"

    private var _departments = MutableLiveData<List<Department>>()
    val departments = _departments

    fun loadDepartments() {
        metService.enqueue(object : Callback<Departments> {
            override fun onResponse(call: Call<Departments>, response: Response<Departments>) {
                Log.d(TAG, "onResponse: " + (response.body()?.departments?.get(0)?.displayName))
                response.body()?.departments.let {
                    if (it != null) {
                        _departments.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<Departments>, t: Throwable) {
                Log.d(TAG, "onFailure: something went wrong " + t.message)
            }
        })
    }

}