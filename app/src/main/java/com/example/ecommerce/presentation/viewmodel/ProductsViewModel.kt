package com.example.ecommerce.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecommerce.data.Result
import com.example.ecommerce.data.model.Product
import com.example.ecommerce.data.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(Result<List<Product>>())
    val uiState = _uiState.asStateFlow()

    fun getProducts() {
        viewModelScope.launch {
            _uiState.value = Result(isLoading = true)
            try {
                val response = productsRepository.getProductData()
                _uiState.value = Result(data = response.products)
            } catch (e: Exception) {
                _uiState.value = Result(error = e.message ?: "Something went wrong")
            }

        }
    }

}