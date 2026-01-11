package com.example.ecommerce.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.navigation.AppNavHost
import com.example.ecommerce.presentation.navigation.BottomNavigationBar

@Composable
fun App(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->

        AppNavHost(
            navController = navController,
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.White)
        )

    }
}