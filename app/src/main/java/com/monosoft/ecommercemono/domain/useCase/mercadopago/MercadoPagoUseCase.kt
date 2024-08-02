package com.monosoft.ecommercemono.domain.useCase.mercadopago

import com.monosoft.ecommercemono.domain.useCase.mercado_pago.CreateCardTokenUseCase
import com.monosoft.ecommercemono.domain.useCase.mercado_pago.CreatePaymentUseCase

data class MercadoPagoUseCase(
    //val getIdentificationType: GetIdentificationTypeUseCase,
    val getInstallments: GetInstallmentsUseCase,
    val createCardToken: CreateCardTokenUseCase,
    val createPayment: CreatePaymentUseCase
)
