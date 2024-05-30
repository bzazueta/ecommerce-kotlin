package com.monosoft.ecommercebenja.domain.repository


import com.monosoft.ecommercebenja.domain.model.Installment
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.domain.model.CardTokenBody
import com.monosoft.ecommercebenja.domain.model.CardTokenResponse
import com.monosoft.ecommercebenja.domain.model.PaymentBody
import com.monosoft.ecommercebenja.domain.model.PaymentResponse
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {

    //fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse>
}