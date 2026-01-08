package com.example.ecommerce.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.screen.cart.CartScreen
import com.example.ecommerce.presentation.screen.favorite.FavoriteScreen
import com.example.ecommerce.presentation.screen.home.HomeScreen

@Composable
fun AppNavHost(modifier: Modifier,navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {

        composable(
            route = BottomNavItem.Home.route
        ) {
            HomeScreen()
        }

        composable(
            route = BottomNavItem.Cart.route
        ) {
            CartScreen()
        }

        composable(
            route = BottomNavItem.Favorite.route
        ) {
            FavoriteScreen()
        }
    }
}