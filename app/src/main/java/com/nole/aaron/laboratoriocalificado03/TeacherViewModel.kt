package com.nole.aaron.laboratoriocalificado03

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TeacherViewModel : ViewModel() {
    private val _teachers = MutableLiveData<List<TeacherResponse>>()
    val teachers: LiveData<List<TeacherResponse>> get() = _teachers

    private val teacherApi: TeacherApi = RetrofitClient.instance.create(TeacherApi::class.java)

    fun fetchTeachers() {
        viewModelScope.launch {
            try {
                val response = teacherApi.getTeachers()
                if (response.isSuccessful) {
                    _teachers.postValue(response.body())
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("API_EXCEPTION", "Exception: ${e.message}")
            }
        }
    }
}
