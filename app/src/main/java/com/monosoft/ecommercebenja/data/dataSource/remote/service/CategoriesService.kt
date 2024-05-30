package com.monosoft.ecommercebenja.data.dataSource.remote.service


import com.monosoft.ecommercebenja.domain.model.Category
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface CategoriesService {

    @GET("categories")
    suspend fun getCategories(): Response<List<Category>>

    @Multipart
    @POST("categories")
    suspend fun create(
        @Part file: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<Category>

    @PUT("categories/{id}")//recibimos el parametro id
    suspend fun update(
        @Path("id") id: String,
        @Body category: Category
    ): Response<Category>

    @Multipart //se usa para separar los parametros que se envian al servidor
    @PUT("categories/upload/{id}")
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part, //para enviar un archivo
        @Path("id") id: String, //path id en la url
        @Part("name") name: RequestBody, //parte que se envia
        @Part("description") description: RequestBody, //parte que se envia
    ): Response<Category>

    @DELETE("categories/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit> //Response<Unit> no regresa datos

}