package com.monosoft.ecommercemono.presentation.screens.client.payments.form

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercemono.domain.model.IdentificationType
import com.monosoft.ecommercemono.domain.useCase.mercadopago.MercadoPagoUseCase
import com.monosoft.ecommercemono.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsFormViewModel @Inject constructor(private val mercadoPagoUseCase: MercadoPagoUseCase): ViewModel() {

    var state by mutableStateOf(ClientPaymentsFormState())
        private set

    var identificationTypesResponse by mutableStateOf<Resource<List<IdentificationType>>?>(null)
        private set


    fun getIdentificationTypes() = viewModelScope.launch {
//        identificationTypesResponse = Resource.Loading
//        val result = mercadoPagoUseCase.getIdentificationType().first()
//        identificationTypesResponse = result
//        Log.d("ClientPaymentsFormViewModel", "Data: ${identificationTypesResponse}")
    }

    fun onCardNumberInput(input: String) {
        state = state.copy(cardNumber = input)
    }

    fun onYearExpirationInput(input: String) {
        state = state.copy(expirationYear = input)
    }

    fun onMonthExpirationInput(input: String) {
        state = state.copy(expirationMonth = input)
    }

    fun onSecurityCodeInput(input: String) {
        state = state.copy(securityCode = input)
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onIdentificationTypeInput(input: String) {
        state = state.copy(type = input)
    }

    fun onIdentificationNumberInput(input: String) {
        state = state.copy(number = input)
    }

}