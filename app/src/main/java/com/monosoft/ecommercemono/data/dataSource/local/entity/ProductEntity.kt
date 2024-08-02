package com.monosoft.ecommercemono.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo("name") var name: String = "",
    @ColumnInfo("description") var description: String = "",
    @ColumnInfo("id_category") var idCategory: String = "",
    @ColumnInfo("image1") var image1: String = "",
    @ColumnInfo("image2") var image2: String = "",
    @ColumnInfo("price") var price: Double = 0.0,
)
