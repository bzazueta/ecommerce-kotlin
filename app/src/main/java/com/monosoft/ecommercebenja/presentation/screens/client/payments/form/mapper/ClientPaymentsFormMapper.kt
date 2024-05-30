package com.monosoft.ecommercebenja.presentation.screens.client.payments.form

import com.monosoft.ecommercebenja.domain.model.Cardholder
import com.monosoft.ecommercebenja.domain.model.Identification
import com.monosoft.ecommercebenja.domain.model.CardTokenBody

fun ClientPaymentsFormState.toCardTokenBody(): CardTokenBody {
    return CardTokenBody(
        cardNumber = cardNumber,
        expirationMonth = expirationMonth.toInt(),
        expirationYear = expirationYear,
        securityCode = securityCode,
        cardholder = Cardholder(
            name = name,
            identification = Identification(
                type = type,
                number = number
            )
        )
    )
}