package com.example.dnd_handbook.repository

import com.example.dnd_handbook.api.RetrofitService

class MainRepository(
    private val retrofitService: RetrofitService
) {
    fun getCategoryList(categoryUrl: String) = retrofitService.getCategoryList(categoryUrl)
}