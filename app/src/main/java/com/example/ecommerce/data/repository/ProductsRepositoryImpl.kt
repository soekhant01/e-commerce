package com.example.ecommerce.data.repository

import com.example.ecommerce.data.model.Products
import com.example.ecommerce.data.remote.api.ApiService

class ProductsRepositoryImpl(
    private val api: ApiService
) : ProductsRepository {
    override suspend fun getProductData(): Products {
        return api.getProducts()
    }
}