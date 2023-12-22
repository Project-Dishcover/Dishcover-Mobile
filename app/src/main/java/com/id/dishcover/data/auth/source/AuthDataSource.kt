package com.id.dishcover.data.auth.source

import android.util.Log
import com.id.dishcover.data.ApiResponse
import com.id.dishcover.data.auth.request.register.RegisterDataRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject


class AuthDataSource @Inject constructor(
    private val apiService: AuthService
) {
    fun register(userData: RegisterDataRequest) = flow {
        emit(
            try {
                val response = apiService.register(
                    name = userData.name,
                    username = userData.username,
                    email = userData.email,
                    password = userData.password
                )
                ApiResponse.Success(response)
            } catch (e: HttpException) {
                when (e.code()) {
                    409 -> ApiResponse.Error("Email atau username sudah digunakan. Silakan gunakan yang lain.")
                    else -> ApiResponse.Error("Unknown Error")
                }
            } catch (e: Exception) {
                ApiResponse.Error(e.message.toString())
            }
        )
    }.flowOn(Dispatchers.IO)

    fun login(username: String, password: String) = flow {
        emit(
            try {
                val response = apiService.login(
                    username = username,
                    password = password
                )
                ApiResponse.Success(response)
            }
            catch (e: HttpException) {
                when (e.code()) {
                    401 -> ApiResponse.Error("Email atau username salah")
                    else -> ApiResponse.Error("Unknown Error")
                }
            }
            catch (e: Exception) {
                Log.e(this@AuthDataSource.javaClass.simpleName, e.message.toString())
                ApiResponse.Error(e.message.toString())
            }
        )
    }.flowOn(Dispatchers.IO)
}