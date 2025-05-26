package com.aafvcinco.parcial_02.ui.screen


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.aafvcinco.parcial_02.data.sampleProducts
import com.aafvcinco.parcial_02.ui.components.ProductCard
import com.aafvcinco.parcial_02.ui.theme.CafeMedio
import com.aafvcinco.parcial_02.ui.theme.CafeOscuro
import com.aafvcinco.parcial_02.ui.theme.CremaSuave



@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun DetailedScreen(navController: NavController, productID: Int?) {
    val context = LocalContext.current
    val product = sampleProducts.find { it.id == productID }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = product?.name ?: "Producto") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        product?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        contentColor = CafeOscuro,
                        containerColor = CremaSuave),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Producto: ${it.name}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Categoría: ${it.category}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Precio: ${it.price}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(it.description)
                        Spacer(modifier = Modifier.height(8.dp))
                        AsyncImage(
                            model = it.img,
                            contentDescription = "imagen",
                            modifier = Modifier.size(220.dp),
                        )
                    }
                }
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = {
                            viewModel.addToCart(product.id)
                        },
                        enabled = !product.addedToCart
                    ) {
                        Text(if (product.addedToCart) "Agregado" else "Agregar al carrito")
                    }
                }
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPetDetailedScreen() {
    val navController = rememberNavController()
    com.aafvcinco.parcial_02.ui.screen.DetailedScreen(navController = navController, productID = 1)
}
