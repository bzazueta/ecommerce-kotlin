package com.monosoft.ecommercemono.domain.useCase.mercadopago

import com.monosoft.ecommercemono.domain.repository.MercadoPagoRepository


class GetInstallmentsUseCase(private val repository: MercadoPagoRepository) {

    operator fun invoke(firstSixDigits: Int, amount: Double) = repository.getInstallments(firstSixDigits, amount)

}