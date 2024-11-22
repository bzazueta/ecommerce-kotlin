package com.monosoft.ecommercemono.data.dataSource.remote.service

import com.monosoft.ecommercemono.domain.model.Url
import retrofit2.Response
import retrofit2.http.GET

interface UrlService {

    @GET("getUrl.php")
    suspend fun getUrlDomain(): Response<List<Url>>
}