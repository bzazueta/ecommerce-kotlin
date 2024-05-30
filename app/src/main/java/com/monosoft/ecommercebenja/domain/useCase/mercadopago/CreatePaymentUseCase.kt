package com.monosoft.ecommercebenja.domain.useCase.mercado_pago

import com.monosoft.ecommercebenja.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercebenja.domain.model.CardTokenBody
import com.monosoft.ecommercebenja.domain.model.PaymentBody


class CreatePaymentUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(paymentBody: PaymentBody) = repository.createPayment(paymentBody)

}