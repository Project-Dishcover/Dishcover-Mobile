package com.id.dishcover.ui.screen;

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.dishcover.datastore.DataStoreManager
import com.id.dishcover.ui.theme.DiSHCOVERTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UIViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
): ViewModel() {
    val _uiState = MutableStateFlow(UIContainerState())
    val uiState: StateFlow<UIContainerState> = _uiState.asStateFlow()

    fun fetchIsLogin() {
        viewModelScope.launch {
            dataStoreManager.readUserToken().collect {
                updateLoginStatus(it.isNotEmpty())
            }
        }
    }
}

fun UIViewModel.updateLoginStatus(isLogin: Boolean) {
    _uiState.update {
        it.copy(
            isLogin = isLogin
        )
    }
}
