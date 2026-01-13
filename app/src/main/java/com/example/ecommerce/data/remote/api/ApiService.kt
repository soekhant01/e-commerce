package com.example.ecommerce.data.remote.api

import com.example.ecommerce.data.model.Products
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }

    @GET("products")
    suspend fun getProducts() : Products
}