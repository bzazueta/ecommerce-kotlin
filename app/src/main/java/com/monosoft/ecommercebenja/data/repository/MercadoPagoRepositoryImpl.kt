package com.monosoft.ecommercebenja.data.repository

import android.util.Log
import com.monosoft.ecommercebenja.domain.model.Installment
import com.monosoft.ecommercebenja.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.domain.util.ResponseToRequest
import com.monosoft.ecommercebenja.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.monosoft.ecommercebenja.domain.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MercadoPagoRepositoryImpl(private val remoteDataSource: MercadoPagoRemoteDataSource):
    MercadoPagoRepository {
//    override fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>> = flow {
//        emit(ResponseToRequest.send(remoteDataSource.getIdentificationTypes()))
//    }

    override fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.getInstallments(firstSixDigits, amount)))
    }

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse> = ResponseToRequest.send(
        remoteDataSource.createCardToken(cardTokenBody)
    )

    override suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse> = ResponseToRequest.send(
        remoteDataSource.createPayment(paymentBody)
    )
}