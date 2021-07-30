package com.example.themet.presentation.explore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themet.models.Department
import com.example.themet.models.Departments
import com.example.themet.models.MetObject
import com.example.themet.models.ObjectIds
import com.example.themet.network.RetrofitSingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreViewModel : ViewModel() {
    private val metService = RetrofitSingleton.metService

    private val TAG = "MetRepository"

    private var _departments = MutableLiveData<List<Department>>()
    val departments = _departments

    private var _objectsInDepartment = MutableLiveData<List<Int>>()
    val objectsInDepartment = _objectsInDepartment

    private var _singleObject = MutableLiveData<MetObject>()
    val singleObject = _singleObject

    fun loadDepartments() {
        metService.getDepartments().enqueue(object : Callback<Departments> {
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

    fun loadAllObjectsInDepartment(id: Int) {
        metService.getAllObjectsInDepartment(id).enqueue(object : Callback<ObjectIds> {
            override fun onResponse(call: Call<ObjectIds>, response: Response<ObjectIds>) {
                Log.d(TAG, "onResponse: " + (response.body()?.objectIDs?.get(0)))
                response.body()?.objectIDs.let {
                    if (it != null) {
                        _objectsInDepartment.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<ObjectIds>, t: Throwable) {
                Log.d(TAG, "onFailure: something went wrong " + t.message)
            }
        })
    }

    fun loadSingleObject(id: Int) {
        metService.getSingleObject(id).enqueue(object : Callback<MetObject> {
            override fun onResponse(call: Call<MetObject>, response: Response<MetObject>) {
                Log.d(TAG, "onResponse: " + (response.body()?.title))
                response.body()?.let {
                    if (it != null) {
                        _singleObject.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<MetObject>, t: Throwable) {
                Log.d(TAG, "onFailure: something went wrong " + t.message)
            }
        })
    }

}