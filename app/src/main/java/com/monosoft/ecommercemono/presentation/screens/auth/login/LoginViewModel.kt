package com.monosoft.ecommercemono.presentation.screens.auth.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercemono.domain.model.AuthResponse
import com.monosoft.ecommercemono.domain.useCase.auth.AuthUseCase
import com.monosoft.ecommercemono.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * clase view model extiende de viewmodel : ViewModel()
 *  @Inject constructorcon esta anotacion podemos inyectar la clase viewmodel en cualquier clase o funcion
 */

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set //variable privada no se puede modificar desde otra clase

    var celPhone by  mutableStateOf<String>("")
    var pwd by  mutableStateOf("")

    var errorMessage by mutableStateOf("")

    // LOGIN RESPONSE
    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun onEmailInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            Log.d("LoginViewModel", "Data: ${data.toJson()}")
            if (!data.token.isNullOrBlank()) {
                loginResponse = Resource.Success(data)
            }
        }
    }

    fun login() = viewModelScope.launch {
        if (isValidForm()) {
          loginResponse = Resource.Loading // ESPERANDO
           val result = authUseCase.login(state.phone, state.password) // RETORNA UNA RESPUESTA
            Log.d("loginViewModel",result.toString())
           loginResponse = result // EXITOSA / ERROR
        }
    }

    fun isValidForm(): Boolean   {

        if (state.phone.isNullOrEmpty()) {
            errorMessage = "Ingresa el celular"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        return true
    }

}