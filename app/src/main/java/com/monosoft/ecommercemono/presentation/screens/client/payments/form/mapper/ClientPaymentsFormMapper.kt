package com.monosoft.ecommercemono.presentation.screens.client.payments.form

import com.monosoft.ecommercemono.domain.model.Cardholder
import com.monosoft.ecommercemono.domain.model.Identification
import com.monosoft.ecommercemono.domain.model.CardTokenBody

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