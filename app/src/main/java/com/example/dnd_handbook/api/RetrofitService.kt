package com.example.dnd_handbook.api

import com.example.dnd_handbook.model.CategoryModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitService {

    companion object {
        private val retrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance(): RetrofitService {
            return retrofitService
        }
    }

    @GET
    fun getCategoryList(@Url url: String): Call<CategoryModel>
}