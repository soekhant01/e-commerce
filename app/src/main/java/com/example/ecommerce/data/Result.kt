package com.example.ecommerce.data

import com.example.ecommerce.data.model.Product

data class Result<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String? = null
)
