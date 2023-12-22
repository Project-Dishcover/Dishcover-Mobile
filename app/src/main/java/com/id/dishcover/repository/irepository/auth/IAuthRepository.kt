package com.id.dishcover.repository.irepository.auth

import com.id.dishcover.data.Resource
import com.id.dishcover.repository.model.register.LoginModel
import com.id.dishcover.repository.model.register.RegisterData
import com.id.dishcover.repository.model.register.RegisterModel
import kotlinx.coroutines.flow.Flow


  

interface IAuthRepository {
    fun register(data: RegisterData): Flow<Resource<RegisterModel>>
    fun login(username: String, password: String): Flow<Resource<LoginModel>>
}