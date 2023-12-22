package com.id.dishcover.data.auth.source

import com.id.dishcover.data.auth.response.login.LoginResponse
import com.id.dishcover.data.auth.response.register.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface AuthService {
    @FormUrlEncoded
    @POST("user/signup")
    suspend fun register(
        @Field("name") name: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): RegisterResponse

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): LoginResponse
}