package com.example.themet.models

import com.google.gson.annotations.SerializedName

data class Department(
       val  departmentId: Int,
       val  displayName: String,
) {}

data class Departments(
       val  departments: List<Department>
) {}

data class ObjectIds(
       @SerializedName("objectIDs")
       val objectIDs: List<Int>
) {}

data class MetObject(
       val objectID: Int,
       val primaryImage: String,
       val department: String,
       val title: String,
       val artistDisplayName: String,
       val artistDisplayBio: String,
       val objectDate: String,
) {}