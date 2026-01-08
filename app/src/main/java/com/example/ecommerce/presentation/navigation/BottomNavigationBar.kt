package com.example.ecommerce.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, navController: NavHostController) {
    val navItems = listOf(
        BottomNavItem.Home, BottomNavItem.Cart, BottomNavItem.Favorite
    )

    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = navItem.route == currentRoute,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = { Icon(painter = painterResource(id = navItem.icon), contentDescription = navItem.label) },
                label = { Text(navItem.label) })

        }
    }
}