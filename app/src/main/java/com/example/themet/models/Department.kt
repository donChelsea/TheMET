package com.example.themet.models

data class Department(
       val  departmentId: Int,
       val  displayName: String,
) {}

data class Departments(
       val  departments: List<Department>
) {}