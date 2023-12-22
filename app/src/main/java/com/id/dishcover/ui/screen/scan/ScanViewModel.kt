package com.id.dishcover.ui.screen.scan

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.dishcover.data.Resource
import com.id.dishcover.repository.irepository.predict.IPredictRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ScanViewModel @Inject constructor(
    private val predictRepository: IPredictRepository
): ViewModel() {
    val _uiState = MutableStateFlow(ScanViewUIState())
    val uiState: StateFlow<ScanViewUIState> = _uiState.asStateFlow()

    fun predict(path: String) {
        viewModelScope.launch {
            predictRepository.predict(path).collect {
                when (it) {
                    is Resource.Error -> handelError(it.message.toString())
                    is Resource.Loading -> handleLoading()
                    is Resource.Success -> handleSuccess(it.data?.result ?:"")
                }
            }
        }
    }
}

data class ScanViewUIState(
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val photoPath: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val nameResult: String = ""
)

fun ScanViewModel.setImagePath(path: String) {
    _uiState.update {
        it.copy(
            photoPath = path
        )
    }
}

fun ScanViewModel.handleLoading() {
    _uiState.update {
        it.copy(
            isSuccess = false,
            isError = false,
            isLoading = true
        )
    }
}
fun ScanViewModel.handleSuccess(resultName: String) {
    _uiState.update {
        it.copy(
            isSuccess = true,
            isError = false,
            isLoading = false,
            nameResult = resultName
        )
    }
}
fun ScanViewModel.handelError(errorMessage: String) {
    _uiState.update {
        it.copy(
            isSuccess = false,
            isError = true,
            isLoading = false,
            errorMessage = errorMessage
        )
    }
}

fun ScanViewModel.resetField() {
    _uiState.update {
        it.copy(
            isSuccess = false,
            isError = false,
            isLoading = false,
            photoPath = "",
        )
    }
}