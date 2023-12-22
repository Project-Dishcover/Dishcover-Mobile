package com.id.dishcover.di.auth

import com.id.dishcover.BuildConfig
import com.id.dishcover.data.auth.source.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


  

@Module
@InstallIn(SingletonComponent::class)
class AuthNetworkModule {
    @Provides
    fun provideAuthApiService(client: OkHttpClient): AuthService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(AuthService::class.java)
    }
}