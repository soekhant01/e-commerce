package com.example.ecommerce.data.model

import com.example.ecommerce.R

data class SampleProduct(
    val title: String,
    val price: Double,
    val imageRes: Int
)


val sampleProducts = listOf(
    SampleProduct("Essence Mascara Lash Princess", 9.99, R.drawable.img1),
    SampleProduct("Calvin Klein CK One", 49.99, R.drawable.img2),
    SampleProduct("Annibale Colombo Bed", 1899.99, R.drawable.img3),
    SampleProduct("Ice Cream", 8.69, R.drawable.img4)

)