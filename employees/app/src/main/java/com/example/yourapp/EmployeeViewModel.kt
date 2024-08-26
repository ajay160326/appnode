package com.example.yourapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmployeeViewModel : ViewModel() {
    private val _employees = MutableLiveData<List<Employee>>(emptyList())
    val employees: LiveData<List<Employee>> get() = _employees

    fun addEmployee(employee: Employee) {
        val currentList = _employees.value ?: emptyList()
        _employees.value = currentList + employee
    }
}
