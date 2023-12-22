package com.id.dishcover.repository.model.register

import com.id.dishcover.data.auth.request.register.RegisterDataRequest
import com.id.dishcover.data.auth.response.login.LoginResponse
import com.id.dishcover.data.auth.response.register.RegisterResponse


  

object RegisterMapper {
    fun registerDataToData(data: RegisterData): RegisterDataRequest = RegisterDataRequest(
        name = data.name, username = data.username, email = data.email, password = data.password
    )

    fun registerResponseToDomain(data: RegisterResponse): RegisterModel = RegisterModel(
        message = data.message, username = data.dataResponse?.username ?: ""
    )
    fun loginResponseToDomain(data: LoginResponse): LoginModel = LoginModel(
        message = data.message, token = data.token ?: ""
    )
}