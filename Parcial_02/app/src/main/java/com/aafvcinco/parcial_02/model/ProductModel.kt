package com.aafvcinco.parcial_02.model

data class Product(
    val id : Int,
    val name: String,
    val category: String,
    val description: String,
    val price: Double,
    val img: String,
    val addedToCarT: Boolean = false
)