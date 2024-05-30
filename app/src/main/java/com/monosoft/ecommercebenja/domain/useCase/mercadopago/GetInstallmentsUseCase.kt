package com.monosoft.ecommercebenja.domain.useCase.mercadopago

import com.monosoft.ecommercebenja.domain.repository.MercadoPagoRepository


class GetInstallmentsUseCase(private val repository: MercadoPagoRepository) {

    operator fun invoke(firstSixDigits: Int, amount: Double) = repository.getInstallments(firstSixDigits, amount)

}