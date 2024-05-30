package com.monosoft.ecommercebenja.domain.repository

import com.monosoft.ecommercebenja.domain.model.Category
import com.monosoft.ecommercebenja.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CategoriesRepository {

    suspend fun create(category: Category, file: File):Resource<Category>
    fun getCategories():Flow<Resource<List<Category>>> //flow se usa para obtener listas en la peticiones no lleva suspend
    suspend fun update(id : String,category: Category):Resource<Category>
    suspend fun updateWithImage(id : String,category: Category,file:File):Resource<Category>
    suspend fun delete(id : String):Resource<Unit>// Resource<Unit> se usa cuando queremos regresar nada de datos o modelos de datos en la respuesta

}