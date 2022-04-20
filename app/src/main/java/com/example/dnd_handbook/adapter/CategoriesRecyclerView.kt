package com.example.dnd_handbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_handbook.R
import com.example.dnd_handbook.model.CategoryModel

class CategoriesRecyclerView(
    private val listCategories: CategoryModel
): RecyclerView.Adapter<CategoriesRecyclerView.CategoriesViewHolder>() {

    inner class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder =
        CategoriesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categories_recyclerview, parent, false))

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val listItem = listCategories.categoryItems[position]
        holder.textViewName.text = listItem.name
    }

    override fun getItemCount(): Int = listCategories.categoryItems.size
}