package com.monosoft.ecommercemono.data.dataSource.remote

import com.monosoft.ecommercemono.domain.model.Installment
import com.monosoft.ecommercemono.domain.model.*
import retrofit2.Response

interface MercadoPagoRemoteDataSource {

    //suspend fun getIdentificationTypes(): Response<List<IdentificationType>>
    suspend fun getInstallments(firstSixDigits: Int, amount: Double): Response<Installment>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse>

}