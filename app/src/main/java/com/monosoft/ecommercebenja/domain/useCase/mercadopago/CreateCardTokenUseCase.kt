package com.monosoft.ecommercebenja.domain.useCase.mercado_pago

import com.monosoft.ecommercebenja.domain.repository.MercadoPagoRepository
import com.monosoft.ecommercebenja.domain.model.CardTokenBody

class CreateCardTokenUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(cardTokenBody: CardTokenBody) = repository.createCardToken(cardTokenBody)

}