package com.aafvcinco.parcial_02.viewModel


import androidx.lifecycle.ViewModel
import com.aafvcinco.parcial_02.data.sampleProducts
import com.aafvcinco.parcial_02.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralViewModel: ViewModel() {
    private val _product = MutableStateFlow<List<Product>>(mutableListOf())
    val products = _product.asStateFlow()
    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()

    fun getProducts() {
        _product.value = sampleProducts
    }
    fun getProductsInCart() {
        _product.value = sampleProducts.filter { it.addedToCarT }
    }
    fun addToCart(productId: Int) {
        _product.value = _product.value.map { product ->
            if (product.id == productId) product.copy(addedToCarT = true)
            else product
        }
    }

}