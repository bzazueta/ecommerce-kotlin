package com.monosoft.ecommercemono.domain.useCase.mercado_pago

import com.monosoft.ecommercemono.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercemono.domain.model.CardTokenBody

class CreateCardTokenUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(cardTokenBody: CardTokenBody) = repository.createCardToken(cardTokenBody)

}