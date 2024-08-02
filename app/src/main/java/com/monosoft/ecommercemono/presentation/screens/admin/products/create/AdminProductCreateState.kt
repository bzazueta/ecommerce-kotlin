package com.monosoft.ecommercemono.presentation.screens.admin.products.create

data class AdminProductCreateState(
    val name: String = "",
    val description: String = "",
    val idCategory: String = "",
    val image1: String = "",
    val image2: String = "",
    val price: Double = 0.0,
)
