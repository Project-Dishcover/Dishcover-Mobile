package com.id.dishcover.data.auth.response.register

import com.google.gson.annotations.SerializedName


data class RegisterResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val dataResponse: RegisterDataResponse?
)