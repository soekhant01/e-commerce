package com.example.ecommerce.presentation.navigation

import com.example.ecommerce.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home: BottomNavItem("home", "Home", R.drawable.ic_home)
    object Cart: BottomNavItem("cart","Cart", R.drawable.ic_cart)
    object Favorite: BottomNavItem("favorite", "Favorite", R.drawable.ic_favorite)

}