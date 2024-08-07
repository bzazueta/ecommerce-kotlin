package com.monosoft.ecommercemono.presentation.screens.admin.category.update

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monosoft.ecommercemono.domain.model.Category
import com.monosoft.ecommercemono.domain.util.Resource
import com.monosoft.ecommercemono.presentation.uti.ComposeFileProvider
import com.monosoft.ecommercemono.presentation.util.ResultingActivityHandler
import com.monosoft.ecommercemono.domain.useCase.categories.CategoriesUseCase
import com.monosoft.ecommercemono.presentation.screens.admin.category.update.mapper.toCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryUpdateViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val categoriesUseCase: CategoriesUseCase,
    @ApplicationContext val context: Context
): ViewModel() {

    var state by mutableStateOf(AdminCategoryUpdateState())
        private set

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)
        private set

    // IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var data = savedStateHandle.get<String>("category") //obtenemos los parametros que se pasan por el navigator AdminCategoryNavGraph
    val category = Category.fromJson(data!!)

    init { // se ejecuta cada vez que llamamos al viewmodel
        state = state.copy(
            name = category.name,
            image = category.image!!,
            description = category.description
        )
    }

    fun onUpdate()  {
        if (file != null) {
            updateCategoryWithImage()
        }
        else {
            updateCategory()
        }
    }

    fun updateCategory() = viewModelScope.launch {
        categoryResponse = Resource.Loading
        val result = categoriesUseCase.updateCategory(category.id ?: "", state.toCategory())
        categoryResponse = result
    }

    fun updateCategoryWithImage() = viewModelScope.launch {
        categoryResponse = Resource.Loading
        val result = categoriesUseCase.updateCategoryWithImage(category.id ?: "", state.toCategory(), file!!)
        categoryResponse = result
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

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }
}