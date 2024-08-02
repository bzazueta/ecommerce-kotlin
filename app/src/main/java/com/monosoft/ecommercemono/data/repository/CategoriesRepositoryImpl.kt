package com.monosoft.ecommercemono.data.repository

import android.util.Log
import com.monosoft.ecommercemono.data.dataSource.local.CategoriesLocalDataSource
import com.monosoft.ecommercemono.data.mappers.toCategory
import com.monosoft.ecommercemono.data.mappers.toCategoryEntity
import com.monosoft.ecommercemono.domain.model.Category
import com.monosoft.ecommercemono.domain.repository.CategoriesRepository
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.domain.util.ResponseToRequest
import com.monosoft.ecommercemono.domain.util.isListEqual
import com.monosoft.ecommercemono.data.dataSource.remote.CategoriesRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.io.File
class CategoriesRepositoryImpl(
    private val remoteDataSource: CategoriesRemoteDataSource,
    private val localDataSource: CategoriesLocalDataSource
): CategoriesRepository {

    override suspend fun create(category: Category, file: File): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.create(category,file)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.create(
                        this.data.toCategoryEntity()
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override fun getCategories(): Flow<Resource<List<Category>>> = flow {

        localDataSource.getCategories().collect() {
            it.run {
                Log.d("localDataSource",this.toString())
                val categoriesLocalMap = this.map { categoryEntity -> categoryEntity.toCategory()  }

                try {
                    ResponseToRequest.send(remoteDataSource.getCategories()).run {
                        when(this) {
                            is Resource.Success -> {
                                val categoriesRemote = this.data
                                Log.d("remoteDataSource",this.data.toString())
                                if (!isListEqual(categoriesRemote, categoriesLocalMap)) {
                                    localDataSource.insertAll(categoriesRemote.map { category -> category.toCategoryEntity() })
                                }

                                emit(Resource.Success(categoriesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                            else -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(categoriesLocalMap))
                }

            }
        }

    }.flowOn(Dispatchers.IO)


    override suspend fun update(id: String, category: Category): Resource<Category> {

        ResponseToRequest.send(remoteDataSource.update(id, category)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }

    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, category, file)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }
}

