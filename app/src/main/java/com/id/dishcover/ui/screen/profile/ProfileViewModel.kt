package com.id.dishcover.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.dishcover.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


  

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
): ViewModel() {
    fun logout() {
        viewModelScope.launch {
            dataStoreManager.deleteUserToken()
        }
    }
}