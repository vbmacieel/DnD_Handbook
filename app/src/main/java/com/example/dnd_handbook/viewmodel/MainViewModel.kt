package com.example.dnd_handbook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dnd_handbook.model.CategoryModel
import com.example.dnd_handbook.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository): ViewModel() {
    val categoryList = MutableLiveData<CategoryModel>()
    val errorMessage = MutableLiveData<String>()

    fun getCategoryList(url: String) {
        val request = repository.getCategoryList(url)
        request.enqueue(object : Callback<CategoryModel> {
            override fun onResponse(
                call: Call<CategoryModel>,
                response: Response<CategoryModel>
            ) {
                categoryList.value = response.body()
            }

            override fun onFailure(call: Call<CategoryModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}