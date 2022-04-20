package com.example.dnd_handbook.model

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("results") val categoryItems: MutableList<CategoryItemsModel>
)
