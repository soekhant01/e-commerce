package com.example.ecommerce.data.repository

import com.example.ecommerce.data.model.Products
import com.example.ecommerce.data.remote.RetrofitInstance

interface ProductsRepository {
    suspend fun getProductData() : Products
}