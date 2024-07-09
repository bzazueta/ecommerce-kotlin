package com.monosoft.ecommercebenja.data.repository

import com.monosoft.ecommercebenja.data.mappers.toProduct
import com.monosoft.ecommercebenja.data.mappers.toProductEntity
import com.monosoft.ecommercebenja.data.dataSource.remote.ProductsRemoteDataSource
import com.monosoft.ecommercebenja.domain.model.Product
import com.monosoft.ecommercebenja.domain.repository.ProductsRepository
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.domain.util.ResponseToRequest
import com.monosoft.ecommercebenja.domain.util.isListEqual
import com.monosoft.ecommercebenja.data.dataSource.local.ProductsLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class ProductsRepositoryImpl(
    private val productsRemoteDataSource: ProductsRemoteDataSource,
    private val productsLocalDataSource: ProductsLocalDataSource

):ProductsRepository {
    override fun findAll(): Flow<Resource<List<Product>>> = flow{

        productsLocalDataSource.findAll().collect() {
            it.run {
                val productsLocalMap = this.map { productEntity -> productEntity.toProduct()  }
                try {
                    ResponseToRequest.send(productsRemoteDataSource.findAll()).run {
                        when(this) {
                            is Resource.Success -> {
                                val productsRemote = this.data

                                if (!isListEqual(productsRemote, productsLocalMap)) {
                                    productsLocalDataSource.insertAll(productsRemote.map { product -> product.toProductEntity() })
                                }

                                emit(Resource.Success(productsRemote))
                            }
                            else -> {
                                emit(Resource.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)//se usa para correr la corrutina en el hilo de la aplicacion

    override fun findByCategory(id: String): Flow<Resource<List<Product>>> = flow {
        productsLocalDataSource.findByCategory(id).collect() {
            it.run {
                val productsLocalMap = this.map { productEntity -> productEntity.toProduct()  }
                try {
                    ResponseToRequest.send(productsRemoteDataSource.findByCategory(id)).run {
                        when(this) {
                            is Resource.Success -> {
                                val productsRemote = this.data

                                if (!isListEqual(productsRemote, productsLocalMap)) {
                                    productsLocalDataSource.insertAll(productsRemote.map { product -> product.toProductEntity() })
                                }

                                emit(Resource.Success(productsRemote))
                            }
                            else -> {
                                emit(Resource.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)//se usa para correr la corrutina en el hilo de la aplicacion

    override fun findByName(name: String): Flow<Resource<List<Product>>> = flow {
        emit(ResponseToRequest.send(productsRemoteDataSource.findByName(name)))
    }

    override suspend fun create(product: Product, files: List<File>): Resource<Product> {
        ResponseToRequest.send(productsRemoteDataSource.create(product, files)).run {
            return when(this) {
                is Resource.Success -> {
                    productsLocalDataSource.insert(this.data.toProductEntity())
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
        product: Product,
        files: List<File>?
    ): Resource<Product> {
        ResponseToRequest.send(productsRemoteDataSource.updateWithImage(id, product, files)).run {
            return when(this) {
                is Resource.Success -> {
                    productsLocalDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        price = this.data.price,
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun update(id: String, product: Product): Resource<Product> {
        ResponseToRequest.send(productsRemoteDataSource.update(id, product)).run {
            return when(this) {
                is Resource.Success -> {
                    productsLocalDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        price = this.data.price,
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
        ResponseToRequest.send(productsRemoteDataSource.delete(id)).run {
            return when(this) {
                is Resource.Success -> {
                    productsLocalDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }
}