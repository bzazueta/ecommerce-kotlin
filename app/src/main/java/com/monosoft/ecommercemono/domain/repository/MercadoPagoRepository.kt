package com.monosoft.ecommercemono.domain.repository


import com.monosoft.ecommercemono.domain.model.Installment
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.domain.model.CardTokenBody
import com.monosoft.ecommercemono.domain.model.CardTokenResponse
import com.monosoft.ecommercemono.domain.model.PaymentBody
import com.monosoft.ecommercemono.domain.model.PaymentResponse
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {

    //fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse>
}