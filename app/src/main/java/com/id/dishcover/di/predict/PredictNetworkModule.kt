package com.id.dishcover.di.predict

import com.id.dishcover.BuildConfig
import com.id.dishcover.data.auth.source.AuthService
import com.id.dishcover.data.predict.source.PredictApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


 

@Module
@InstallIn(SingletonComponent::class)
class PredictNetworkModule {
    @Provides
    fun provideAuthApiService(client: OkHttpClient): PredictApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_PREDICTION_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(PredictApiService::class.java)
    }
}