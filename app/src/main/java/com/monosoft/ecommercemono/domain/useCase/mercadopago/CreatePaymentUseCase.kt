package com.monosoft.ecommercemono.domain.useCase.mercado_pago

import com.monosoft.ecommercemono.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercemono.domain.model.PaymentBody


class CreatePaymentUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(paymentBody: PaymentBody) = repository.createPayment(paymentBody)

}