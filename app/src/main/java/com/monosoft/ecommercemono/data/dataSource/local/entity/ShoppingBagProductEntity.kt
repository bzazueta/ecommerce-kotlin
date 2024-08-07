package com.monosoft.ecommercemono.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_bag")
data class ShoppingBagProductEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo("name") var name: String = "",
    @ColumnInfo("id_category") var idCategory: String = "",
    @ColumnInfo("image1") var image1: String = "",
    @ColumnInfo("price") var price: Double = 0.0,
    @ColumnInfo("quantity") var quantity: Int = 0,
)
