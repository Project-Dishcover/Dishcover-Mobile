package com.id.dishcover.ui.screen.auth.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.dishcover.data.Resource
import com.id.dishcover.data.auth.AuthRepository
import com.id.dishcover.repository.model.register.RegisterData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


  

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    val _uiState = MutableStateFlow(RegisterUIState())
    val uiState: StateFlow<RegisterUIState> = _uiState.asStateFlow()

    fun register(name: String, email: String, username: String, password: String) {
        viewModelScope.launch {
            authRepository.register(RegisterData(
                name = name,
                username = username,
                email = email,
                password = password
            )).collect {
                when (it) {
                    is Resource.Error -> handleError(it.message.toString())
                    is Resource.Loading -> {}
                    is Resource.Success -> handleSuccess()
                }
            }
        }
    }
}

fun RegisterViewModel.handleError(message: String) {
    _uiState.update {
        it.copy(
            errorMessage = message,
            isError = true,
            isSuccess = false
        )
    }
}

fun RegisterViewModel.handleSuccess() {
    _uiState.update {
        it.copy(
            isError = false,
            isSuccess = true
        )
    }
}

data class RegisterUIState(
    val errorMessage: String = "",
    val isSuccess: Boolean = false,
    val isError: Boolean = false
)