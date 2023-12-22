package com.id.dishcover.di.datastore

import android.content.Context
import com.id.dishcover.datastore.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


  

@Module
@InstallIn(SingletonComponent::class)
object DataStore {
    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context = context)
    }
}