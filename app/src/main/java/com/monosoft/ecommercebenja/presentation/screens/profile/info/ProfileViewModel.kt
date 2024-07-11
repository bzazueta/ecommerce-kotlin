package com.monosoft.ecommercebenja.presentation.screens.profile.info

import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.useCase.auth.AuthUseCase
import com.monosoft.ecommercebenja.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    var userDeleteResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            user = data.user
        }
    }

    fun logout() = viewModelScope.launch {
        authUseCase.logout()
    }

    fun deletUser(idUser : String) = viewModelScope.launch {
        idUser.toString()
        userDeleteResponse = Resource.Loading
        val result = authUseCase.deleteAccountUseCase(idUser)
        userDeleteResponse = result
        delay(4000)
        logout()
    }

}