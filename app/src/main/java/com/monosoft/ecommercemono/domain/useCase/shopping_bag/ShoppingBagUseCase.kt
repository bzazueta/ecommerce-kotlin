package com.monosoft.ecommercemono.domain.useCase.shopping_bag

data class ShoppingBagUseCase(
    val add: AddUseCase,
    val delete: DeleteUseCase,
    val findAll: FindAllShoppingBagUseCase,
    val findById: FindByIdShoppingBagUseCase,
    val getTotal: GetTotalUseCase
)
