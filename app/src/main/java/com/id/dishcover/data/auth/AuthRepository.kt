package com.id.dishcover.data.auth

import com.id.dishcover.data.ApiResponse
import com.id.dishcover.data.Resource
import com.id.dishcover.data.auth.source.AuthDataSource
import com.id.dishcover.datastore.DataStoreManager
import com.id.dishcover.repository.irepository.auth.IAuthRepository
import com.id.dishcover.repository.model.register.LoginModel
import com.id.dishcover.repository.model.register.RegisterData
import com.id.dishcover.repository.model.register.RegisterMapper.loginResponseToDomain
import com.id.dishcover.repository.model.register.RegisterMapper.registerDataToData
import com.id.dishcover.repository.model.register.RegisterMapper.registerResponseToDomain
import com.id.dishcover.repository.model.register.RegisterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val dataSource: AuthDataSource,
    private val dataStoreManager: DataStoreManager
): IAuthRepository {
    override fun register(data: RegisterData): Flow<Resource<RegisterModel>> = flow {
        emit(Resource.Loading())
        emit(when (val response = dataSource.register(registerDataToData(data)).first()) {
            is ApiResponse.Error -> Resource.Error(response.error)
            is ApiResponse.Success -> Resource.Success(registerResponseToDomain(response.data))
        })
    }

    override fun login(username: String, password: String): Flow<Resource<LoginModel>> = flow {
        emit(Resource.Loading())
        emit(when (val response = dataSource.login(username = username, password= password).first()) {
            is ApiResponse.Error -> Resource.Error(response.error)
            is ApiResponse.Success -> {
                val userModel = loginResponseToDomain(response.data)
                dataStoreManager.storeUserToken("Bearer ${userModel.token}")
                Resource.Success(userModel)
            }
        })
    }
}