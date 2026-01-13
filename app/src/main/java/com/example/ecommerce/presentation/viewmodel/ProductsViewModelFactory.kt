package com.example.ecommerce.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.data.repository.ProductsRepository

class ProductsViewModelFactory(
    private val repository: ProductsRepository
) : ViewModelProvider.Factory  {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}