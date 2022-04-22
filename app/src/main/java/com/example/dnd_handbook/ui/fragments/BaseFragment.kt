package com.example.dnd_handbook.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_handbook.R
import com.example.dnd_handbook.adapter.CategoriesRecyclerView
import com.example.dnd_handbook.api.RetrofitService
import com.example.dnd_handbook.model.CategoryModel
import com.example.dnd_handbook.repository.MainRepository
import com.example.dnd_handbook.viewmodel.MainViewModel
import com.example.dnd_handbook.viewmodel.MainViewModelFactory

abstract class BaseFragment: Fragment(R.layout.list_fragment) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var retrofitService: RetrofitService.Companion
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        return view
    }

    abstract fun getUrlValue(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        viewModel.getCategoryList(getUrlValue())
    }

    override fun onStart() {
        super.onStart()
        viewModel.categoryList.observe(this) {
            setUpRecyclerView(it)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(view?.context, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setUpRecyclerView(categoryItemsList: CategoryModel) {
        recyclerView = view?.findViewById(R.id.recyclerview_layout)!!
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        val categoriesRecyclerView = CategoriesRecyclerView(categoryItemsList)
        recyclerView.adapter = categoriesRecyclerView
    }

    private fun setViewModel() {
        retrofitService = RetrofitService
        viewModel = ViewModelProvider(this, MainViewModelFactory(
            MainRepository(retrofitService.getInstance())))
            .get(MainViewModel::class.java)
    }
}