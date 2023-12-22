package com.id.dishcover.di

import com.id.dishcover.data.auth.AuthRepository
import com.id.dishcover.data.predict.PredictRepository
import com.id.dishcover.repository.irepository.auth.IAuthRepository
import com.id.dishcover.repository.irepository.predict.IPredictRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


  

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideAuthRepository(authRepository: AuthRepository): IAuthRepository

    @Binds
    @ViewModelScoped
    abstract fun providePredictRepository(predictRepository: PredictRepository): IPredictRepository
}