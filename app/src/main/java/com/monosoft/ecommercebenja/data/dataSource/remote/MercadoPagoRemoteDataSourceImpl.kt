package com.monosoft.ecommercebenja.data.dataSource.remote


import com.monosoft.ecommercebenja.data.dataSource.remote.service.MercadoPagoService
import com.monosoft.ecommercebenja.domain.model.IdentificationType
import com.monosoft.ecommercebenja.domain.model.Installment
import com.monosoft.ecommercebenja.domain.model.*
import retrofit2.Response

class MercadoPagoRemoteDataSourceImpl(private val mercadoPagoService: MercadoPagoService): MercadoPagoRemoteDataSource {
   // override suspend fun getIdentificationTypes(): Response<List<IdentificationType>>  = mercadoPagoService.getIdentificationTypes()

    override suspend fun getInstallments(
        firstSixDigits: Int,
        amount: Double
    ): Response<Installment> = mercadoPagoService.getInstallments(firstSixDigits, amount)

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse> = mercadoPagoService.createCardToken(cardTokenBody)
    override suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse> = mercadoPagoService.createPayment(paymentBody)
}