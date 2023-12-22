package com.id.dishcover.ui.screen.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.dishcover.data.Resource
import com.id.dishcover.repository.irepository.auth.IAuthRepository
import com.id.dishcover.ui.screen.auth.register.handleError
import com.id.dishcover.ui.screen.auth.register.handleSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


  

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: IAuthRepository
): ViewModel() {
    val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()
    fun login(username: String, password: String) {
        viewModelScope.launch {
            authRepository.login(username, password).collect {
                when (it) {
                    is Resource.Error -> handleError(it.message.toString())
                    is Resource.Loading -> {}
                    is Resource.Success -> handleSuccess()
                }
            }
        }
    }
}

fun LoginViewModel.handleError(message: String) {
    _uiState.update {
        it.copy(
            errorMessage = message,
            isError = true,
            isSuccess = false
        )
    }
}

fun LoginViewModel.handleSuccess() {
    _uiState.update {
        it.copy(
            isError = false,
            isSuccess = true
        )
    }
}

data class LoginUIState(
    val errorMessage: String = "",
    val isSuccess: Boolean = false,
    val isError: Boolean = false
)