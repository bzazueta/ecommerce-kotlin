package com.monosoft.ecommercemono.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercemono.domain.model.AuthResponse
import com.monosoft.ecommercemono.domain.useCase.auth.AuthUseCase
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.presentation.screens.auth.register.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set
    var errorMessage by mutableStateOf("")

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }
    fun onlastNameInput(lastName: String) {
        state = state.copy(lastName = lastName)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String) {
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(password: String) {
        state = state.copy(confirmPassword = password)
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun isValidForm(): Boolean {

        if (state.name == "") {
            errorMessage = "Ingresa el nombre"
            return false
        }
        else if (state.lastName == "") {
            errorMessage = "Ingresa el apellido"
            return false
        }
        else if (state.email == "") {
            errorMessage = "Ingresa el email"
            return false
        }
        else if (state.phone == "") {
            errorMessage = "Ingresa el telefono"
            return false
        }
        else if (state.password == "") {
            errorMessage = "Ingresa el password"
            return false
        }
        else if (state.confirmPassword == "") {
            errorMessage = "Ingresa el password de confirmacion"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if (state.password != state.confirmPassword) {
            errorMessage = "Las contraseñas no coinciden"
            return false
        }

        return true
    }

    fun register() = viewModelScope.launch {

        if (isValidForm()) {
            registerResponse = Resource.Loading
            val result = authUseCase.register(state.toUser())
            registerResponse = result // DATA / ERROR
        }
    }

}