package com.example.ecommerce.presentation.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R

import com.example.ecommerce.data.model.Product
import com.example.ecommerce.ui.theme.EcommerceTheme

@Composable
fun ProductCart(modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF4F6F8)
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 32.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img1),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text("Essence Mascara Lash Princess", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier.height(8.dp))
            Text("$9.99", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier.height(16.dp))


        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ProductCartPreview() {
    EcommerceTheme() {
        ProductCart()
    }
}