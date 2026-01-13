package com.example.ecommerce.data.repository

import com.example.ecommerce.data.model.Products
import com.example.ecommerce.data.remote.RetrofitInstance

class ProductRepository {
    suspend fun getProductData() : Products? {
        val api = RetrofitInstance.api
        return try {
            return api.getProducts()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}