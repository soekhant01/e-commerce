package com.example.ecommerce.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.data.UiState
import com.example.ecommerce.data.model.Product
import com.example.ecommerce.data.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<Product>>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {

            try {
                val response = productsRepository.getProductData()
                _uiState.value = UiState.Success(response.products)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(
                    e.message ?: "Something went wrong"
                )
            }

        }
    }

}