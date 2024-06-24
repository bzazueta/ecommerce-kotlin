package com.monosoft.ecommercebenja.presentation.screens.profile.update

import android.content.Context
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercebenja.domain.model.User
import com.monosoft.ecommercebenja.domain.useCase.auth.AuthUseCase
import com.monosoft.ecommercebenja.domain.useCase.users.UsersUseCase
import com.monosoft.ecommercebenja.domain.util.Resource
import com.monosoft.ecommercebenja.presentation.screens.profile.update.ProfileUpdateState
import com.monosoft.ecommercebenja.presentation.uti.ComposeFileProvider
import com.monosoft.ecommercebenja.presentation.util.ResultingActivityHandler
import com.monosoft.ecommercebenja.presentation.screens.profile.update.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UsersUseCase,
    private val savedStateHandle: SavedStateHandle,// para poder recibor los argumentos
    @ApplicationContext private val context: Context //inyectamos el contexto
): ViewModel() {

    var state by mutableStateOf(ProfileUpdateState())
    private val _stateFlow: MutableStateFlow<ProfileUpdateState> = MutableStateFlow(ProfileUpdateState())
    val stateFlow: StateFlow<ProfileUpdateState> = _stateFlow.asStateFlow()
    // ARGUMENTS
    //val data = savedStateHandle.get<String>("user")//para poder recibor los argumentos
    //var user = User.fromJson(data!!)
    var user by mutableStateOf<User?>(null)
        private set
   // var user = User("1","we","","","","","","", emptyList(),null)
    // IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()



    var updateResponse by mutableStateOf<Resource<User>?>(null)
        private set

    init {
//        state = state.copy(
//            name = user!!.name,
//            lastname = user!!.lastname,
//            phone = user!!.phone,
//            image = user!!.image ?: ""
//        )
    }

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            user = data.user
                    state = state.copy(
                            name = user!!.name,
                            lastname = user!!.lastname,
                            phone = user!!.phone,
                            image = user!!.image ?: ""
                   )
            _stateFlow.update {
                state.copy(
                    name = user!!.name,
                    lastname = user!!.lastname,
                    phone = user!!.phone,
                    image = user!!.image ?: ""
                )
            }

        }
    }

    //actualizamos la sesion
    fun updateUserSession(userResponse: User) = viewModelScope.launch {
        authUseCase.updateSession(userResponse)
    }

    fun onUpdate() {
        if (file != null) { // SI SELECCIONO UNA IMAGEN
            updateWithImage()
        }
        else {
            update()
        }
    }

    fun updateWithImage() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUserWithImage(user?.id ?: "", state.toUser(), file!!) //state.toUser() mapeamos los datos del usuario
        updateResponse = result
    }

    fun update() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUser(user?.id ?: "", state.toUser())
        updateResponse = result
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*") // URI
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String) {
        state = state.copy(lastname = input)
    }

    fun onImageInput(input: String) {
        state = state.copy(image = input)
    }

    fun onPhoneInput(input: String) {
        state = state.copy(phone = input)
    }

    fun params(user : User){
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            image = user.image ?: ""
        )


    }

}