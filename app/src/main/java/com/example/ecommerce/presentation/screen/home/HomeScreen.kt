package com.example.ecommerce.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecommerce.R
import com.example.ecommerce.data.UiState
import com.example.ecommerce.data.model.Product
import com.example.ecommerce.data.remote.RetrofitInstance
import com.example.ecommerce.data.remote.api.ApiService
import com.example.ecommerce.data.repository.ProductsRepositoryImpl
import com.example.ecommerce.presentation.component.ProductCart
import com.example.ecommerce.presentation.viewmodel.ProductsViewModel
import com.example.ecommerce.presentation.viewmodel.ProductsViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {


    val repository = ProductsRepositoryImpl(RetrofitInstance.api) // create your repo instance
    val viewModel: ProductsViewModel = viewModel(
        factory = ProductsViewModelFactory(repository)
    )

    val state by viewModel.uiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())



    Scaffold(

        containerColor = Color.White, topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF4F6F8),

                    ), title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = modifier) {

                            Text("ET-Shop", fontWeight = FontWeight.Bold)
                            Text(
                                "5,000+ products and categories",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(R.drawable.ic_cart_filled),
                                contentDescription = null
                            )
                        }
                    }

                }, scrollBehavior = scrollBehavior
            )
        }

    ) { innerPadding ->


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),

            ) {

            when (state) {

                is UiState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillParentMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                is UiState.Success<List<Product>> -> {
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Best Seller Items", fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.padding(start = 16.dp))
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyRowProduct(products = (state as UiState.Success<List<Product>>).data)
                    }
                }

                is UiState.Error -> {}
            }


//
//            item {
//                Spacer(modifier.height(32.dp))
//                Text("Recommend For You", fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.padding(start = 16.dp))
//                Spacer(modifier.height(16.dp))
//                LazyRowProduct()
//            }
//
//            item {
//                Spacer(modifier.height(32.dp))
//                Text("Recommend For You", fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.padding(start = 16.dp))
//                Spacer(modifier.height(16.dp))
//                LazyRowProduct()
//            }
//
//
//            item {
//                Spacer(modifier.height(32.dp))
//                Text("Recommend For You", fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.padding(start = 16.dp))
//                Spacer(modifier.height(16.dp))
//                LazyRowProduct()
//                Spacer(modifier.height(100.dp))
//
//            }
        }

    }
}

@Composable
fun LazyRowProduct(modifier: Modifier = Modifier, products: List<Product>) {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            ProductCart(
                product = product,
            )
        }
    }
}

@Composable
fun CircularProgressIndicatorFunc() {
    CircularProgressIndicator()
}

@Preview
@Composable
private fun HomePreview() {
    HomeScreen()
}