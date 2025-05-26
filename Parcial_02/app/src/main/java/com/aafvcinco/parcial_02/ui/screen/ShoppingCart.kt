package com.aafvcinco.parcial_02.ui.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aafvcinco.parcial_02.data.sampleProducts
import com.aafvcinco.parcial_02.model.Product
import com.aafvcinco.parcial_02.ui.components.ProductCard
import com.aafvcinco.parcial_02.viewModel.GeneralViewModel
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCardScreen(
    modifier: Modifier = Modifier,
    viewModel: GeneralViewModel,
    navController: NavController
) {

    //obtención de datos de mascotas
    val lista = remember { mutableStateListOf<Product>() }
    val openDialog = remember { mutableStateOf(false) }
    val newCard = remember { mutableStateOf(Product(0, "", "", "", 0.0,"")) }
    val products by viewModel.products.collectAsState()

    //para guardar en el global view model
    val product = Product(
        id = newCard.value.id,
        name = newCard.value.name,
        category = newCard.value.category,
        description = newCard.value.description,
        price = newCard.value.price,
        img = newCard.value.img,
        addedToCarT = newCard.value.addedToCarT
    )


    //Obtención de datos sin sobrecarga
    LaunchedEffect(Unit) {
        viewModel.getProductsInCart()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shopping cart ") }
            )
        }
    ){
            innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(16.dp)
        ){

            Spacer(modifier = Modifier.height(16.dp))

            if(products.isEmpty()) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column(

                    ) {
                        Text("No hay productos agregados")
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(products){ product ->
                        ProductCard(
                            name = product.name,
                            price = product.price,
                            category = product.category,
                            img = product.img,
                            onClick = {navController.navigate("productDetails/${product.id}")}


                        )
                    }

            }
        }
    }
    }
}