package com.aafvcinco.parcial_02.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aafvcinco.parcial_02.ui.theme.CafeMedio
import com.aafvcinco.parcial_02.ui.theme.CremaSuave
import java.nio.file.WatchEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aafvcinco.parcial_02.R



@Composable
public fun ProductCard(
    name : String,
    category: String,
    img : String,
    price : Double,
    isPreview: Boolean = false,
    addedToCart: Boolean = false,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable{onClick()} ,
        colors = CardDefaults.cardColors(
            contentColor = CafeMedio,
            containerColor = CremaSuave
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),


        ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column (
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Nombre: $name",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Text(
                        text = "Categoría: $category",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Text(
                        text = "Precio: $ $price",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Column (
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    if (isPreview) {
                        Image(
                            painter = painterResource(id = R.drawable.dog),
                            contentDescription = "imagen de perro",
                            modifier = Modifier.size(100.dp)
                        )
                    } else {
                        AsyncImage(
                            model = img,
                            contentDescription = "imagen",
                            modifier = Modifier.size(100.dp).padding(8.dp),

                            )
                    }
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun PetCardPreview(){
    ProductCard(
        name = "Maya",
        category= "perro",
        img = "",
        price = 22.60,
        isPreview = true,
        onClick = {} //vacío para visualizar
    )
}

