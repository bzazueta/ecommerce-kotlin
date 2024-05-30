package com.monosoft.ecommercebenja.presentation.screens.client.payments.status

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.monosoft.ecommercebenja.domain.model.PaymentResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsStatusViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val data = savedStateHandle.get<String>("payment_response")
    var paymentResponse = PaymentResponse.fromJson(data!!)



}