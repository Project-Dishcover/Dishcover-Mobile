package com.id.dishcover.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


  

const val DATA_STORE = "dataStore"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE)
class DataStoreManager(private val context: Context) {
    companion object{
        val SHOW_ON_BOARDING = booleanPreferencesKey("showOnBoarding")
        val USER_TOKEN = stringPreferencesKey("userToken")
    }
    suspend fun storeOnBoarding(showOnBoarding : Boolean){
        context.dataStore.edit {
            it[SHOW_ON_BOARDING] = showOnBoarding
        }
    }
    fun getShowOnBoardingDataStore(): Flow<Boolean> {
        return context.dataStore.data.map { preference ->
            preference[SHOW_ON_BOARDING] ?: true
        }
    }
    suspend fun storeUserToken(token: String) {
        context.dataStore.edit {
            it[USER_TOKEN] = token
        }
    }

    suspend fun deleteUserToken() {
        context.dataStore.edit {
            it.clear()
        }
    }

    fun readUserToken(): Flow<String> {
        return context.dataStore.data.map {preference ->
            preference[USER_TOKEN] ?: ""
        }
    }
}